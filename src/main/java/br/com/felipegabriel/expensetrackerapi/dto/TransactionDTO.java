package br.com.felipegabriel.expensetrackerapi.dto;

import br.com.felipegabriel.expensetrackerapi.enums.TransactionType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class TransactionDTO {

    private Integer id;

    private String description;

    private BigDecimal value;

    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private TransactionCategoryDTO transactionCategory;

    private Integer user;
}
