package com.salman.roomieBudgetTracker.controller;

import com.salman.roomieBudgetTracker.entity.Accounts;

import com.salman.roomieBudgetTracker.entity.Address;
import com.salman.roomieBudgetTracker.entity.States;
import com.salman.roomieBudgetTracker.service.AccountsService;
import com.salman.roomieBudgetTracker.service.StatesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountsController {

    private final StatesService statesService;
    private final AccountsService accountsService;
    @Autowired
    public AccountsController(StatesService statesService, AccountsService accountsService) {
        this.statesService = statesService;
        this.accountsService = accountsService;
    }

    @GetMapping("/register")
    public String register(Model model){
        System.out.println("-------------IN REGISTER----------------");
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

        System.out.println("------------FROM REGISTER/NEW------------");
        System.out.println("get state name:"+address.getStateName());
        System.out.println(selectedState);
        System.out.println(accounts);
        System.out.println(address);
        Address newAdress = address;
        accounts.setAddressId(address);
        accountsService.addNewAccount(accounts);


        return "demo-success-page";

    }

   /* @GetMapping("/login")
    public String login(Model model){

        return "login";
    }*/


}
