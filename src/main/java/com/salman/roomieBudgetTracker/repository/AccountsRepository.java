package com.salman.roomieBudgetTracker.repository;

import com.salman.roomieBudgetTracker.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
}
