package br.com.felipegabriel.expensetrackerapi.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    @Column(name = "user_password")
    private String password;
}
