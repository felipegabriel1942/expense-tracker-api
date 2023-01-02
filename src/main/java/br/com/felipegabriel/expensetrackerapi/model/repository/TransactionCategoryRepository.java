package br.com.felipegabriel.expensetrackerapi.model.repository;

import br.com.felipegabriel.expensetrackerapi.model.entity.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Integer> {

}