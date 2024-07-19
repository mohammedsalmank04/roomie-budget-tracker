package com.salman.roomieBudgetTracker.service;

import com.salman.roomieBudgetTracker.entity.Accounts;
import com.salman.roomieBudgetTracker.entity.UsersType;
import com.salman.roomieBudgetTracker.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountsService {

    private final AccountsRepository accountsRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AccountsService(AccountsRepository accountsRepository, PasswordEncoder passwordEncoder) {
        this.accountsRepository = accountsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Accounts addNewAccount(Accounts account){
        account.setRegistrationDate(new Date(System.currentTimeMillis()));
        account.setPassword(passwordEncoder.encode(account.getPassword()));

        UsersType accountType = new UsersType(1,"Root");
        account.setUsersTypeId(accountType);
        accountsRepository.save(account);
        return account;
    }
}
