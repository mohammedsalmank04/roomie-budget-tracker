package com.salman.roomieBudgetTracker.util;

import com.salman.roomieBudgetTracker.entity.Accounts;
import com.salman.roomieBudgetTracker.entity.Address;

public class RegisterForm {
    private Accounts account;
    private Address address;

    public RegisterForm() {
    }

    public RegisterForm(Accounts account, Address address) {
        this.account = account;
        this.address = address;

    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "account=" + account +
                ", address=" + address +
                '}';
    }
}
