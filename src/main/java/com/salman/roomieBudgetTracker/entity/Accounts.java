

package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Accounts implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String password;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date registrationDate;
    @ManyToOne()
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
    private UsersType usersTypeId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address addressId;
    @OneToMany(mappedBy = "account")
    private List<TokenBlacklist> tokens;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UsersType usersType = this.getUsersTypeId();
        List<SimpleGrantedAuthority> accountAuthoritiesList = new ArrayList<>();
        accountAuthoritiesList.add(new SimpleGrantedAuthority(usersType.getUserTypeName()));
        return accountAuthoritiesList;
    }

    @Override
    public String getUsername() {
        return null;
    }
    public String getPassword(){
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
