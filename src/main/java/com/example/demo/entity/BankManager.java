package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BankManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;
    
    private String name;
    private String email;
    private Long phoneNumber;

    @ManyToOne
    private Bank bank; // Foreign key relationship

    // Constructors, Getters, and Setters

    public BankManager() {
    }

    public BankManager(String name, String email, Long phoneNumber, Bank bank) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bank = bank;
    }

    // Getters and Setters
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "BankManager [managerId=" + managerId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
                + ", bank=" + bank + "]";
    }
}
