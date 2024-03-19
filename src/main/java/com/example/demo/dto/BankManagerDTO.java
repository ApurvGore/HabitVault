package com.example.demo.dto;

public class BankManagerDTO {

    private Long managerId;
    private String managerName;
    private String email;
    private String phoneNumber;

    // Constructors, Getters, and Setters

    public BankManagerDTO() {
    }

    public BankManagerDTO(Long managerId, String managerName, String email, String phoneNumber) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "BankManagerDTO{" +
                "managerId=" + managerId +
                ", managerName='" + managerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
