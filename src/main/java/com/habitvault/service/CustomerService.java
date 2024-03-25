package com.habitvault.service;

import org.springframework.core.io.Resource;

import com.habitvault.dto.AccountDTO;
import com.habitvault.dto.TransactionDTO;
import com.habitvault.entity.Account;
import com.habitvault.entity.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Account> getAccountDetails(Long customerId);

    void deposit(Long customerId, Double amount);

    void withdraw(Long customerId, Double amount);

    void transfer(Long senderCustomerId, Long receiverCustomerId, Double amount);

    List<TransactionDTO> getTransactionHistory(Long customerId);

    Resource downloadAccountStatement(Long customerId);

	Customer getCustomerById(Long customerId);

	void addAccount(AccountDTO accountDTO);
}
