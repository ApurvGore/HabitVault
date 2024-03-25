package com.habitvault.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    
    private String adminName;
    private String adminEmail;
    private String password;
    private Long phoneNumber;

    // Constructors, Getters, and Setters

    public Admin() {
    }

    public Admin(String adminName, String email, String password, Long phoneNumber) {
        this.adminName = adminName;
        this.adminEmail = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", name=" + adminName + ", email=" + adminEmail + ", phoneNumber=" + phoneNumber
                + "]";
    }
}
