package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "token_blacklist")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TokenBlacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String token;
    private boolean expired;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts account;
}
