package br.com.felipegabriel.expensetrackerapi.mapper;

import br.com.felipegabriel.expensetrackerapi.dto.TransactionDTO;
import br.com.felipegabriel.expensetrackerapi.model.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mappings({
            @Mapping(source = "user.id", target = "user")
    })
    TransactionDTO toDto(Transaction transaction);

    @Mappings({
            @Mapping(source = "user", target = "user.id")
    })
    Transaction toEntity(TransactionDTO transaction);

    List<TransactionDTO> toListDto(List<Transaction> transactions);
}
