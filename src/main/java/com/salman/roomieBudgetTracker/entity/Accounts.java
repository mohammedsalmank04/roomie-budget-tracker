//************ PENDING TO ADD ADDRESS ****************//

package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String password;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date registrationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
    private UsersType usersTypeId;

    public Accounts() {
    }

    public Accounts(int accountId, String email, String password, Date registrationDate, UsersType usersTypeId) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.usersTypeId = usersTypeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UsersType getUserTypeId() {
        return usersTypeId;
    }

    public void setUserTypeId(UsersType usersTypeId) {
        this.usersTypeId = usersTypeId;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", userTypeId=" + usersTypeId +
                '}';
    }
}
