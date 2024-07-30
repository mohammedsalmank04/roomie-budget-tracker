package com.salman.roomieBudgetTracker.service;

import com.salman.roomieBudgetTracker.entity.Accounts;
import com.salman.roomieBudgetTracker.repository.AccountsRepository;
import com.salman.roomieBudgetTracker.util.CustomAccountDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomAccountDetailsService implements UserDetailsService {
    private final AccountsRepository accountsRepository;

    public CustomAccountDetailsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts account = accountsRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Could not find User"));
        return new CustomAccountDetails(account);
    }
}
