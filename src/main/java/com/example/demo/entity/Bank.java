package com.example.demo.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;
    
    private String branchName;
    private String address;
    private Long phoneNumber;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<BankManager> managers;

    // Constructors, Getters, and Setters

    public Bank() {
    }

    public Bank(String branchName, String address, Long phoneNumber) {
        this.branchName = branchName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BankManager> getManagers() {
        return managers;
    }

    public void setManagers(List<BankManager> managers) {
        this.managers = managers;
    }

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "Bank [bankId=" + bankId + ", branchName=" + branchName + ", address=" + address + ", phoneNumber=" + phoneNumber
                + "]";
    }
}
