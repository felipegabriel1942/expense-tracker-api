package br.com.felipegabriel.expensetrackerapi.config.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageEnum {

    TRANSACTION_SAVED("Transação salva com sucesso!"),
    TRANSACTION_DELETED("Transação excluída com sucesso!"),
    TRANSACTION_UPDATED("Transação atualizada com sucesso!"),
    TRANSACTIONS_FOUND("Transações encontradas com sucesso!"),
    TRANSACTIONS_SUMMARY_FOUND("Resumo das transações do periodo calculadas com sucesso!"),
    TRANSACTIONS_EXPENSE_SUMMARY_FOUND("Resumo das transações de despesas por categoria do periodo calculadas com sucesso!"),
    CATEGORIES_FOUND("Categorias encontradas com sucesso!"),
    TYPES_FOUND("Tipos de transações encontradas com sucesso!");

    private final String value;

}
