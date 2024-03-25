package com.habitvault.service;

import java.util.List;

import com.habitvault.dto.BankManagerDTO;
import com.habitvault.entity.Account;
import com.habitvault.entity.Bank;
import com.habitvault.entity.BankManager;
import com.habitvault.entity.Customer;
import com.habitvault.exception.BankNotFoundException;
import com.habitvault.exception.ResourceNotFoundException;

public interface AdminService {
    // Add other method declarations as needed
	List<BankManagerDTO> getAllBankManagers();
	List<Bank> getAllBanks();
	List<Customer> getAllCustomers();
	List<Account> getCustomerAccounts(Long customerId);
	Customer getCustomerDetails(Long customerId);
	void addBank(Bank bank);
	void addBankManager(BankManagerDTO bankManagerDTO) throws BankNotFoundException;
}
