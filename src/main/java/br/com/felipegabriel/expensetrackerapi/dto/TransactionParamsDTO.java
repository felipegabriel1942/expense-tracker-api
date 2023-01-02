package br.com.felipegabriel.expensetrackerapi.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter @Getter
public class TransactionParamsDTO {
    private Integer page;
    private Integer elementsPerPage;
    private boolean expense;
    private boolean revenue;
    private Integer userId;
    private String period;
}
