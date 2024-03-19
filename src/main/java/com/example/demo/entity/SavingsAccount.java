package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends Account {

    // Constructors
    public SavingsAccount() {
        super();
    }

    public SavingsAccount(double balance, Customer customer) {
        super(balance, customer);
    }

    // toString method
    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountId=" + getAccountId() +
                ", balance=" + getBalance() +
                ", customer=" + getCustomer() +
                '}';
    }
}
