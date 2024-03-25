package com.habitvault.dto;

public class BankManagerDTO {
	 private String name;
	 private String email;
	    
	 private Long phoneNumber;
	 private String bankName;
	 
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public BankManagerDTO(String name, String email, Long phoneNumber, String bankName) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.bankName = bankName;
	}
	public BankManagerDTO() {
		super();
	}
	 
	 
}
