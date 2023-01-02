package br.com.felipegabriel.expensetrackerapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
    REVENUE("Receita"),
    EXPENSE("Despesa");

    private String value;

    TransactionType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TransactionType fromValue(String value) {
        if (TransactionType.EXPENSE.getValue().equals(value) ) {
            return TransactionType.EXPENSE;
        }

        if (TransactionType.REVENUE.getValue().equals(value) ) {
            return TransactionType.REVENUE;
        }

        throw new IllegalArgumentException();
    }
}
