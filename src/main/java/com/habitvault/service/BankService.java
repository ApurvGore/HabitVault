package com.habitvault.service;

import org.springframework.core.io.Resource;

import com.habitvault.entity.Account;
import com.habitvault.entity.Customer;
import com.habitvault.entity.Transaction;

import java.util.List;

public interface BankService {

    void registerCustomer(Customer customer);

    List<Customer> getAllBankCustomers();

    List<Account> getAllBankAccounts();

    void deposit(Long customerId, Double amount);

    void withdraw(Long customerId, Double amount);

    List<Transaction> getTransactionHistory(Long customerId);

    Resource downloadBankStatement(Long customerId);

	void transfer(Long senderCustomerId, Long receiverCustomerId, Double amount);
}
