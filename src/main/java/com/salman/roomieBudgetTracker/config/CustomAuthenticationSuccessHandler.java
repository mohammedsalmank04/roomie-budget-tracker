package com.salman.roomieBudgetTracker.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userName = userDetails.getUsername();
        System.out.println("The Username: "+userName+" is logged in");

        boolean hasRoot = authentication.getAuthorities().stream().allMatch(r->r.getAuthority().equals("Root"));
        boolean hasResident = authentication.getAuthorities().stream().allMatch(r->r.getAuthority().equals("Resident"));
        boolean hasGuest = authentication.getAuthorities().stream().allMatch(r->r.getAuthority().equals("Guest"));

        if(hasRoot || hasGuest || hasResident){
            response.sendRedirect("/demo-success-page/");
        }
    }
}
