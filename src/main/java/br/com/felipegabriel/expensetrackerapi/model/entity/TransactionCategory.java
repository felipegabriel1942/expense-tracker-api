package br.com.felipegabriel.expensetrackerapi.model.entity;

import br.com.felipegabriel.expensetrackerapi.enums.TransactionType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "transaction_category")
@Setter @Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name ="transaction_type")
    private TransactionType transactionType;
}
