package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class CurrentAccount extends Account {

    // Constructors
    public CurrentAccount() {
        super();
    }

    public CurrentAccount(double balance, Customer customer) {
        super(balance, customer);
    }

    // toString method
    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountId=" + getAccountId() +
                ", balance=" + getBalance() +
                ", customer=" + getCustomer() +
                '}';
    }
}
