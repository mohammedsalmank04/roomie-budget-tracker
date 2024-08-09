package com.salman.roomieBudgetTracker.repository;

import com.salman.roomieBudgetTracker.entity.TokenBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenBlacklistRepository extends JpaRepository<TokenBlacklist, Integer> {

    @Query("""
            select tb from TokenBlacklist tb inner join Accounts a on tb.account.id = a.id
            where a.id = :accountId and (tb.expired = false)
            """)
    List<TokenBlacklist> findAllValidTokenByUser(Integer accountId);
    Optional<TokenBlacklist> findByToken(String token);
}
