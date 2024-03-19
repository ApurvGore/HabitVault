package com.example.demo.dto;

import java.math.BigDecimal;

public class AccountDTO {

    private Long accountId;
    private String accountType;
    private BigDecimal balance;

    // Constructors, Getters, and Setters

    public AccountDTO() {
    }

    public AccountDTO(Long accountId, String accountType, BigDecimal balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // toString method
    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
