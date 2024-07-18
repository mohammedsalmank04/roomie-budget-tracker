//****** NEED TO ADD STATE ID AND ACCOUNT ID ****************//

package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String address;

    private String country;

    public Address() {
    }

    public Address(int addressId, String address, String country) {
        this.addressId = addressId;
        this.address = address;
        this.country = country;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
