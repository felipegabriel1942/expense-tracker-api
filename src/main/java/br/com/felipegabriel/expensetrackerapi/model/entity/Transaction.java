package br.com.felipegabriel.expensetrackerapi.model.entity;

import br.com.felipegabriel.expensetrackerapi.enums.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(name ="transaction_type")
    private TransactionType transactionType;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "transaction_category")
    private TransactionCategory transactionCategory;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
