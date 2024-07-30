package com.salman.roomieBudgetTracker.controller;

import com.salman.roomieBudgetTracker.entity.Accounts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("account",new Accounts());

        return "login";
    }
}
