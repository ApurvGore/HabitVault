package com.example.demo.dto;

public class BankDTO {

    private Long bankId;
    private String bankName;
    private String branchName;
    private String phoneNumber;

    // Constructors, Getters, and Setters

    public BankDTO() {
    }

    public BankDTO(Long bankId, String bankName, String branchName, String phoneNumber) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.branchName = branchName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "BankDTO{" +
                "bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
