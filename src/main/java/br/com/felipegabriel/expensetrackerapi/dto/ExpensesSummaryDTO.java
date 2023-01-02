package br.com.felipegabriel.expensetrackerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor
public class ExpensesSummaryDTO {
    private String category;
    private BigDecimal total;
}
