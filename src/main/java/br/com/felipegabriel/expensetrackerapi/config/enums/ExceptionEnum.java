package br.com.felipegabriel.expensetrackerapi.config.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    TRANSACTION_NOT_FOUND(1, "error.transactionNotFound", HttpStatus.BAD_REQUEST);

    private final Integer code;

    private final String messageKey;

    private final HttpStatus httpStatus;
}
