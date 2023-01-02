package br.com.felipegabriel.expensetrackerapi.dto;

import br.com.felipegabriel.expensetrackerapi.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter @Setter
public class TransactionSummaryDTO {

    private TransactionType transactionType;

    private BigDecimal total;

}
