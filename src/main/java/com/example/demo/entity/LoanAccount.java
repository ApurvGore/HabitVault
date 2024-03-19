package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class LoanAccount extends Account {

    // Constructors
    public LoanAccount() {
        super();
    }

    public LoanAccount(double balance, Customer customer) {
        super(balance, customer);
    }

    // toString method
    @Override
    public String toString() {
        return "LoanAccount{" +
                "accountId=" + getAccountId() +
                ", balance=" + getBalance() +
                ", customer=" + getCustomer() +
                '}';
    }
}
