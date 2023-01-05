package br.com.felipegabriel.expensetrackerapi.controller;

import br.com.felipegabriel.expensetrackerapi.dto.ApiResponseDTO;
import br.com.felipegabriel.expensetrackerapi.dto.TransactionCategoryDTO;
import br.com.felipegabriel.expensetrackerapi.service.TransactionCategoryService;
import br.com.felipegabriel.expensetrackerapi.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction-category")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TransactionCategoryController {

    private final TransactionCategoryService transactionCategoryService;

    @GetMapping("categories")
    public ResponseEntity<ApiResponseDTO<List<TransactionCategoryDTO>>> findTransactionCategories() {
        List<TransactionCategoryDTO> categories = transactionCategoryService.findTransactionCategories();
        return new ResponseUtil().ok(categories);
    }
}
