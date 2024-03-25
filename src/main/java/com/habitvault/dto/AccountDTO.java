package com.habitvault.dto;

public class AccountDTO {

    private Long accountId;
    private double balance;
    private String customerName;
    private String accountType;

    // Constructors, Getters, and Setters

    public AccountDTO() {
    }

    public AccountDTO(Long accountId, double balance, String customerName, String accountType) {
        this.accountId = accountId;
        this.balance = balance;
        this.customerName = customerName;
        this.accountType = accountType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
