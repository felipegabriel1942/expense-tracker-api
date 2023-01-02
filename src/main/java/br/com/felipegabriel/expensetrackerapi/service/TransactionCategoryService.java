package br.com.felipegabriel.expensetrackerapi.service;

import br.com.felipegabriel.expensetrackerapi.dto.TransactionCategoryDTO;
import br.com.felipegabriel.expensetrackerapi.mapper.TransactionCategoryMapper;
import br.com.felipegabriel.expensetrackerapi.model.entity.TransactionCategory;
import br.com.felipegabriel.expensetrackerapi.model.repository.TransactionCategoryRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionCategoryService {

    private final TransactionCategoryRepository transactionCategoryRepository;

    private final TransactionCategoryMapper transactionCategoryMapper;

    public List<TransactionCategoryDTO> findTransactionCategories() {
        return  transactionCategoryRepository.findAll().stream()
                    .map(transactionCategoryMapper::toDto)
                    .collect(Collectors.toList());
    }
}
