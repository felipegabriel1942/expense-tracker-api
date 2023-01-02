package br.com.felipegabriel.expensetrackerapi.controller;

import br.com.felipegabriel.expensetrackerapi.dto.*;
import br.com.felipegabriel.expensetrackerapi.config.enums.MessageEnum;
import br.com.felipegabriel.expensetrackerapi.service.TransactionCategoryService;
import br.com.felipegabriel.expensetrackerapi.service.TransactionService;
import br.com.felipegabriel.expensetrackerapi.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionCategoryService transactionCategoryService;

    @PostMapping("create")
    public ResponseEntity<Void> save(@RequestBody TransactionDTO transactionDTO) {
        transactionService.save(transactionDTO);
        return new ResponseUtil().ok(MessageEnum.TRANSACTION_SAVED);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestParam("id") Integer id) {
        transactionService.delete(id);
        return new ResponseUtil().ok(MessageEnum.TRANSACTION_DELETED);
    }

    @PutMapping("update")
    public ResponseEntity<Void> update(@RequestBody TransactionDTO transactionDTO) {
        transactionService.update(transactionDTO);
        return new ResponseUtil().ok(MessageEnum.TRANSACTION_UPDATED);
    }

    @GetMapping("find")
    public ResponseEntity<ApiResponseDTO<PageDTO<TransactionDTO>>> findTransactions(
            TransactionParamsDTO transactionParams) {
        PageDTO<TransactionDTO> transactions = transactionService.findTransactions(transactionParams);
        return new ResponseUtil().ok(transactions);
    }

    @GetMapping("summary")
    public ResponseEntity<ApiResponseDTO<List<TransactionSummaryDTO>>> getSummary(
            TransactionParamsDTO transactionParams) {
        List<TransactionSummaryDTO> summary = transactionService.getTransactionSummary(transactionParams);
        return new ResponseUtil().ok(summary);
    }

    @GetMapping("summary/expenses")
    public ResponseEntity<ApiResponseDTO<List<ExpensesSummaryDTO>>> getExpenseSummary(
            TransactionParamsDTO transactionParams) {
        List<ExpensesSummaryDTO> summary = transactionService.getExpenseSummaryByCategory(transactionParams);
        return new ResponseUtil().ok(summary);
    }

    @GetMapping("categories")
    public ResponseEntity<ApiResponseDTO<List<TransactionCategoryDTO>>> findTransactionCategories() {
        List<TransactionCategoryDTO> categories = transactionCategoryService.findTransactionCategories();
        return new ResponseUtil().ok(categories);
    }
}
