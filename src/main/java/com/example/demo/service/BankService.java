package com.example.demo.service;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.TransactionDTO;
import org.springframework.core.io.Resource;

import java.math.BigDecimal;
import java.util.List;

public interface BankService {

    void registerCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllBankCustomers();

    List<AccountDTO> getAllBankAccounts();

    void deposit(Long customerId, BigDecimal amount);

    void withdraw(Long customerId, BigDecimal amount);

    void transfer(Long senderCustomerId, Long receiverCustomerId, BigDecimal amount);

    List<TransactionDTO> getTransactionHistory(Long customerId);

    Resource downloadBankStatement(Long customerId);
}
