package br.com.felipegabriel.expensetrackerapi.mapper;

import br.com.felipegabriel.expensetrackerapi.dto.TransactionCategoryDTO;
import br.com.felipegabriel.expensetrackerapi.model.entity.TransactionCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionCategoryMapper {

    TransactionCategoryDTO toDto(TransactionCategory transactionCategory);

    TransactionCategory toEntity(TransactionCategoryDTO transactionCategoryDTO);

    List<TransactionCategoryDTO> toListDto(List<TransactionCategory> transactionCategoryList);
}
