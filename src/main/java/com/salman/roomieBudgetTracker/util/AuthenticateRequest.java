package com.salman.roomieBudgetTracker.util;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticateRequest {
    public String email;
    public String password;
}
