package br.com.felipegabriel.expensetrackerapi.service;

import br.com.felipegabriel.expensetrackerapi.dto.*;
import br.com.felipegabriel.expensetrackerapi.exception.TransactionNotFound;
import br.com.felipegabriel.expensetrackerapi.mapper.TransactionMapper;
import br.com.felipegabriel.expensetrackerapi.model.entity.Transaction;
import br.com.felipegabriel.expensetrackerapi.model.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper;

    public void save(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.toEntity(transactionDTO);
        transactionRepository.save(transaction);
    }

    public void delete(Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if (transaction.isEmpty()) {
            throw new TransactionNotFound();
        }

        transactionRepository.delete(transaction.get());
    }

    public void update(TransactionDTO transactionDTO) {
        if (Objects.isNull(transactionDTO.getId())) {
            throw new TransactionNotFound();
        }

        Transaction transaction = transactionMapper.toEntity(transactionDTO);

        transactionRepository.save(transaction);
    }

    public PageDTO<TransactionDTO> findTransactions(TransactionParamsDTO params) {
        Pageable pageable = PageRequest.of(params.getPage(), params.getElementsPerPage());
        Page<Transaction> page = transactionRepository.findTransactions(params, pageable);
        List<TransactionDTO> transactions = transactionMapper.toListDto(page.getContent());
        return new PageDTO<TransactionDTO>().map(page, transactions);
    }

    public List<TransactionSummaryDTO> getTransactionSummary(TransactionParamsDTO params) {
        return transactionRepository.getTransactionSummaryByPeriod(params);
    }

    public List<ExpensesSummaryDTO> getExpenseSummaryByCategory(TransactionParamsDTO params) {
        return transactionRepository.getExpenseSummaryByCategory(params);
    }
}
