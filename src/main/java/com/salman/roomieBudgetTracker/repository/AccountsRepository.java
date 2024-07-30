package com.salman.roomieBudgetTracker.repository;

import com.salman.roomieBudgetTracker.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts,Integer> {

    Optional<Accounts> findByEmail(String email);
}
