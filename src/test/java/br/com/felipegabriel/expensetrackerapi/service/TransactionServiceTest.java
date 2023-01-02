package br.com.felipegabriel.expensetrackerapi.service;

import br.com.felipegabriel.expensetrackerapi.dto.PageDTO;
import br.com.felipegabriel.expensetrackerapi.dto.TransactionDTO;
import br.com.felipegabriel.expensetrackerapi.dto.TransactionParamsDTO;
import br.com.felipegabriel.expensetrackerapi.exception.TransactionNotFound;
import br.com.felipegabriel.expensetrackerapi.mapper.TransactionMapper;
import br.com.felipegabriel.expensetrackerapi.model.entity.Transaction;
import br.com.felipegabriel.expensetrackerapi.model.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

public class TransactionServiceTest {
    private TransactionService transactionService;
    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionMapper transactionMapper;

    @Captor
    private ArgumentCaptor<Transaction> captor;

    private TransactionDTO transaction;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.transactionService = new TransactionService(transactionRepository, transactionMapper);
        this.transaction = transaction();
    }

    @Test
    public void shouldSaveAnTransaction() {
        TransactionDTO transaction = transaction();
        transactionService.save(transaction);
        Mockito.verify(transactionRepository).save(Mockito.any());
    }

    @Test
    public void shouldThrowAnTransactionNotFoundExceptionWhenDeleting() {
        Mockito.when(transactionRepository.findById(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(TransactionNotFound.class, () -> {
            transactionService.delete(1);
        });
    }

    @Test
    public void shouldDeleteAnTransaction() {
        Transaction transaction = new ModelMapper().map(transaction(), Transaction.class);

        Mockito.when(transactionRepository.findById(1)).thenReturn(Optional.of(transaction));

        transactionService.delete(1);

        Mockito.verify(transactionRepository).delete(transaction);
    }

    @Test
    public void shouldThrowAnTransactionNotFoundWhenUpdating() {
        Assertions.assertThrows(TransactionNotFound.class, () -> {
            transactionService.update(new TransactionDTO());
        });
    }

    @Test
    public void shouldUpdateAnTransaction() {
        this.transaction.setId(1);

        transactionService.update(transaction);

        Mockito.verify(transactionRepository).save(Mockito.any());
    }

    @Test
    public void shouldFindAndListOfTransactions() {
        Pageable pageable = PageRequest.of(0, 1);

        Page<Transaction> transactionsPage = new PageImpl<>(Arrays.asList(new Transaction()), pageable, 1);

        Mockito
                .when(transactionRepository.findTransactions(Mockito.any(), Mockito.any()))
                .thenReturn(transactionsPage);

        TransactionParamsDTO params = TransactionParamsDTO.builder()
                .elementsPerPage(10)
                .page(0).build();

        PageDTO<TransactionDTO> response =  transactionService.findTransactions(params);

        Assertions.assertEquals(1, response.getTotalOfPages());
        Assertions.assertEquals(1, response.getContent().size());
        Assertions.assertEquals(0, response.getPage());
        Assertions.assertEquals(1, response.getTotalOfElements());
        Assertions.assertEquals(true, response.isLastPage());
    }


    private TransactionDTO transaction() {
        return TransactionDTO.builder()
                .creationDate(LocalDateTime.now())
                .description("Description")
                .value(BigDecimal.valueOf(150))
                .build();
    }
}
