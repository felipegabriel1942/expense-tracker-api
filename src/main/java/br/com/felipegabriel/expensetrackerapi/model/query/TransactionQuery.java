package br.com.felipegabriel.expensetrackerapi.model.query;

public abstract class TransactionQuery {

    public static final String FIND_TRANSACTIONS = "select t from Transaction t " +
            "where " +
            "((t.transactionType = 'REVENUE' and :#{#params.revenue} = true) or (t.transactionType = 'EXPENSE' and :#{#params.expense} = true)) " +
            "and t.user.id = :#{#params.userId} " +
            "and concat(year(t.creationDate), '-', month(t.creationDate)) = :#{#params.period} " +
            "order by t.id desc ";

    public static final String GET_TRANSACTION_SUMMARY = "select new br.com.felipegabriel.expensetrackerapi.dto.TransactionSummaryDTO(" +
            "   t.transactionType, " +
            "   sum(t.value)) " +
            " from Transaction t " +
            " where" +
            "  concat(year(t.creationDate), '-', month(t.creationDate)) = :#{#params.period} " +
            "  and t.user.id = :#{#params.userId}" +
            " group by" +
            "  t.transactionType";

    public static final String GET_EXPENSES_SUMMARY_BY_CATEGORY  = "select new br.com.felipegabriel.expensetrackerapi.dto.ExpensesSummaryDTO(" +
            "   t.transactionCategory.description, " +
            "   sum(t.value)) " +
            " from Transaction t " +
            " where" +
            "  concat(year(t.creationDate), '-', month(t.creationDate)) = :#{#params.period} " +
            "  and t.transactionType = 'EXPENSE' " +
            "  and t.user.id = :#{#params.userId} " +
            " group by" +
            "  t.transactionCategory.description";
}
