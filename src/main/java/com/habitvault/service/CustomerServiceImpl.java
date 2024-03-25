package com.habitvault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.habitvault.dto.AccountDTO;
import com.habitvault.dto.TransactionDTO;
import com.habitvault.entity.Account;
import com.habitvault.entity.AccountType;
import com.habitvault.entity.Customer;
import com.habitvault.exception.CustomerNotFoundException;
import com.habitvault.repository.AccountRepository;
import com.habitvault.repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;

    @Override
    public Optional<Account> getAccountDetails(Long customerId) {
        // Implement logic to retrieve account details for the customer
        return accountRepository.findById(customerId);
    }

    @Override
    public void deposit(Long customerId, Double amount) {
        // Implement logic to perform account deposit
    	Optional<Customer> fetchedCustomer = customerRepository.findById(customerId);
    }

    @Override
    public void withdraw(Long customerId, Double amount) {
        // Implement logic to perform account withdrawal
    }

    @Override
    public void transfer(Long senderCustomerId, Long receiverCustomerId, Double amount) {
        // Implement logic to perform account transfer
    }

    @Override
    public List<TransactionDTO> getTransactionHistory(Long customerId) {
        // Implement logic to retrieve transaction history for the customer
        return null;
    }

    @Override
    public Resource downloadAccountStatement(Long customerId) {
        // Implement logic to generate and download account statement
        return null;
    }

    @Override
	public Customer getCustomerById(Long customerId) {
		return customerRepository.getById(customerId);
	}

    @Override
	public void addAccount(AccountDTO accountDTO) {
		Customer customer = customerRepository.findByCustomerName(accountDTO.getCustomerName());
		if(customer == null) {
			throw new CustomerNotFoundException("Bank account cannot be added, customer does not exist. Add customer first.");
		} else {
			Account account = new Account(accountDTO.getBalance(), customer, AccountType.valueOf(accountDTO.getAccountType().toUpperCase()));
			accountRepository.save(account);
		}
	}

	public Customer getCustomerByName(String customerName) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerName(customerName);
	}
}
