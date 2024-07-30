package com.salman.roomieBudgetTracker.service;

import com.salman.roomieBudgetTracker.entity.Accounts;
import com.salman.roomieBudgetTracker.entity.Address;
import com.salman.roomieBudgetTracker.entity.UsersType;
import com.salman.roomieBudgetTracker.repository.AccountsRepository;
import com.salman.roomieBudgetTracker.repository.AddressRepository;
import com.salman.roomieBudgetTracker.repository.UsersTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsService {

    private final AccountsRepository accountsRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;
    private final JwtService jwtService;
    private final UsersTypeRepository usersTypeRepository;


    public void addNewAccount(Accounts account, Address address){
        List<UsersType> usersTypeList = usersTypeRepository.findAll();
        account.setRegistrationDate(new Date(System.currentTimeMillis()));
        account.setAddressId(address);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setUsersTypeId(usersTypeList.get(1));

        System.out.println(usersTypeList);
        System.out.println(account);


        //UsersType accountType = new UsersType(1,"Root");
        //account.setUsersTypeId(accountType);
        //addressRepository.save(account.getAddressId());

        accountsRepository.save(account);
        var jwtToken = jwtService.generateToken(account);
        System.out.println("TOKEN:- "+jwtToken);

    }
}
