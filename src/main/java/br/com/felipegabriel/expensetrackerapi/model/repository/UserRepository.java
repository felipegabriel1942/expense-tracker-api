package br.com.felipegabriel.expensetrackerapi.model.repository;

import br.com.felipegabriel.expensetrackerapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
