package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BankDTO;
import com.example.demo.dto.BankManagerDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Bank;
import com.example.demo.entity.BankManager;
import com.example.demo.entity.Customer;

public interface AdminService {
    // Add other method declarations as needed
    void addBankManager(BankManagerDTO bankManagerDTO);
	List<BankManager> getAllBankManagers();
	List<Bank> getAllBanks();
	List<Customer> getAllCustomers();
	List<Account> getCustomerAccounts(Long customerId);
	Customer getCustomerDetails(Long customerId);
	void addBank(Bank bank);
}
