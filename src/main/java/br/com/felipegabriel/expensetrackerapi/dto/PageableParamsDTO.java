package br.com.felipegabriel.expensetrackerapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableParamsDTO {
    private Integer page;
    private Integer elementsPerPage;
}
