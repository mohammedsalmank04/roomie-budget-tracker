package com.salman.roomieBudgetTracker.service;

import com.salman.roomieBudgetTracker.repository.TokenBlacklistRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {
    private TokenBlacklistRepository tokenBlacklistRepository;
    @Override
    public void logout( HttpServletRequest request,
                        HttpServletResponse response,
                        Authentication authentication
    ) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;

        //The auth token should always start with BEARER if not send a 403 back to client
        if(authHeader == null || !(authHeader.startsWith("Bearer "))){
            System.out.println("authHeader is null");
            return;
        }
        jwt = authHeader.substring(7);
        var storedToken = tokenBlacklistRepository.findByToken(jwt).orElse(null);
        if(storedToken != null){
            storedToken.setExpired(true);
            tokenBlacklistRepository.save(storedToken);
            SecurityContextHolder.clearContext();
        }

    }
}
