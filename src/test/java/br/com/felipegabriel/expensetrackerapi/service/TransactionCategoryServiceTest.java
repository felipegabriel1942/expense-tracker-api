package br.com.felipegabriel.expensetrackerapi.service;

import br.com.felipegabriel.expensetrackerapi.dto.TransactionCategoryDTO;
import br.com.felipegabriel.expensetrackerapi.mapper.TransactionCategoryMapper;
import br.com.felipegabriel.expensetrackerapi.model.entity.TransactionCategory;
import br.com.felipegabriel.expensetrackerapi.model.repository.TransactionCategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class TransactionCategoryServiceTest {

    private TransactionCategoryService transactionCategoryService;

    @Mock
    private TransactionCategoryRepository transactionCategoryRepository;

    @Mock
    private TransactionCategoryMapper transactionCategoryMapper;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.transactionCategoryService = new TransactionCategoryService(transactionCategoryRepository, transactionCategoryMapper);
    }


    @Test
    public void shouldFindTransactionCategories() {
        TransactionCategory category = TransactionCategory.builder()
                .id(1)
                .description("Presente")
                .build();

        List<TransactionCategoryDTO> categories = transactionCategoryService.findTransactionCategories();

        Assertions.assertEquals(1, categories.size());
        Assertions.assertEquals(1, categories.get(0).getId());
        Assertions.assertEquals("Presente", categories.get(0).getDescription());
    }
}
