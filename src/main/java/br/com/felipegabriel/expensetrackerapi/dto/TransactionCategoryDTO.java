package br.com.felipegabriel.expensetrackerapi.dto;
import br.com.felipegabriel.expensetrackerapi.enums.TransactionType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCategoryDTO {

    private Integer id;

    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}
