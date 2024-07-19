

package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private String address1;

    private String country;
    private String stateName;

    private int zipCode;


    public Address() {
        System.out.println("In address cons");
    }

    public Address(int addressId, String address, String country, String stateName, int zipCode) {
        this.addressId = addressId;
        this.address1 = address;
        this.country = country;
        this.stateName = stateName;
        this.zipCode = zipCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        System.out.println(addressId);
        this.addressId = addressId;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateName() {
        return stateName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        System.out.println(zipCode);
        this.zipCode = zipCode;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        System.out.println(address1);
        this.address1 = address1;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address1='" + address1 + '\'' +
                ", country='" + country + '\'' +
                ", stateName='" + stateName + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
