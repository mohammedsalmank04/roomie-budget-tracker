package com.salman.roomieBudgetTracker.controller;

import com.salman.roomieBudgetTracker.entity.Accounts;

import com.salman.roomieBudgetTracker.entity.Address;
import com.salman.roomieBudgetTracker.entity.States;
import com.salman.roomieBudgetTracker.repository.AccountsRepository;
import com.salman.roomieBudgetTracker.service.AccountsService;
import com.salman.roomieBudgetTracker.service.StatesService;

import com.salman.roomieBudgetTracker.util.AuthenticateRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AccountsController {

    private final StatesService statesService;
    private final AccountsService accountsService;
    private final AccountsRepository accountsRepository;


    @GetMapping("/register")
    public String register(Model model){
        //System.out.println("-------------IN REGISTER----------------");
        List<States> statesList = statesService.getAll();
        String selectedState = "";
        model.addAttribute("account",new Accounts());
        model.addAttribute("address",new Address());
        model.addAttribute("getAllStates",statesList);
        model.addAttribute("selectedState",selectedState);


        return "register";
    }

    @PostMapping("/register/new")
    public String accountRegistration(@ModelAttribute("account") Accounts accounts,
                                      Model model,
                                      @ModelAttribute("address") Address address,
                                      @ModelAttribute("selectedState") String selectedState
                                      ){


        accountsService.addNewAccount(accounts,address);


        return "demo-success-page";

    }

   @PostMapping("/login")
    public String login(@RequestParam(value = "email") String email,
                        @RequestParam(value = "password")  String password,
                        Model model
   ){
       /*System.out.println(email);
       System.out.println("IN LOGIN POST MAPPING METHOD");*/
       var user = AuthenticateRequest.builder().email(email).password(password).build();
       Accounts account= accountsService.authenticate(user);

        Address address = account.getAddressId();
       //System.out.println(account);
        model.addAttribute("account",account);
        model.addAttribute("address",address);

        return "home";
   }




}
