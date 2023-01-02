package br.com.felipegabriel.expensetrackerapi.model.repository;

import br.com.felipegabriel.expensetrackerapi.dto.ExpensesSummaryDTO;
import br.com.felipegabriel.expensetrackerapi.dto.TransactionParamsDTO;
import br.com.felipegabriel.expensetrackerapi.dto.TransactionSummaryDTO;
import br.com.felipegabriel.expensetrackerapi.model.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static br.com.felipegabriel.expensetrackerapi.model.query.TransactionQuery.*;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(FIND_TRANSACTIONS)
    Page<Transaction> findTransactions(TransactionParamsDTO params, Pageable pageable);

    @Query(GET_TRANSACTION_SUMMARY)
    List<TransactionSummaryDTO> getTransactionSummaryByPeriod(TransactionParamsDTO params);

    @Query(GET_EXPENSES_SUMMARY_BY_CATEGORY)
    List<ExpensesSummaryDTO> getExpenseSummaryByCategory(TransactionParamsDTO params);

}
