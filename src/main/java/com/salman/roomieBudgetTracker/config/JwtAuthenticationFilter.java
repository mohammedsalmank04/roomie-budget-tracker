package com.salman.roomieBudgetTracker.config;

import com.salman.roomieBudgetTracker.repository.AccountsRepository;
import com.salman.roomieBudgetTracker.service.AccountsService;
import com.salman.roomieBudgetTracker.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
     private final UserDetailsService userDetailsService;

    //Once per request filter make sure that we run the filter chain everytime we send a request
    //Tell spring this class to be a Spring Bean
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        //This header contains JWT Header token
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String accountEmail;
        //The auth token should always start with BEARER if not send a 403 back to client
        if(authHeader == null || !(authHeader.startsWith("Bearer "))){
            filterChain.doFilter(request,response);
            return;
        }
        jwt = authHeader.substring(7);
        accountEmail = jwtService.extractUsername(jwt);

        if(accountEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = (UserDetails) userDetailsService.loadUserByUsername(accountEmail);
            if(jwtService.isTokenValid(jwt,userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
