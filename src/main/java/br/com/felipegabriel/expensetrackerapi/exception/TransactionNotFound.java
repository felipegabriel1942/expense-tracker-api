package br.com.felipegabriel.expensetrackerapi.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TransactionNotFound extends RuntimeException{

    public TransactionNotFound(String message) {
        super(message);
    }
}
