package com.habitvault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.habitvault.entity.Account;
import com.habitvault.entity.Customer;
import com.habitvault.entity.Transaction;
import com.habitvault.exception.BankAccountNotFoundException;
import com.habitvault.exception.CustomerNotFoundException;
import com.habitvault.exception.InsufficientBalanceException;
import com.habitvault.repository.AccountRepository;
import com.habitvault.repository.CustomerRepository;
import com.habitvault.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

    @Override
    public void registerCustomer(Customer customer) {
        // Implement logic to register a customer
    	customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllBankCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Account> getAllBankAccounts() {
        // Implement logic to retrieve all bank accounts
        return accountRepository.findAll();
    }

//    @Override
//    public void deposit(Long customerId, Double amount) {
//        Customer customer = customerRepository.findById(customerId).orElse(null);
//        if (customer != null) {
//            // Get the customer's account
//            Account account = customer.getAccounts().get(0);
//
//            // Check if the account exists
//            if (account != null) {
//                // Update the balance by adding the deposit amount
//                double currentBalance = account.getBalance();
//                double newBalance = currentBalance + amount;
//                account.setBalance(newBalance);
//
//                // Save the updated account to the database
//                accountRepository.save(account);
//            } else {
//                // If the account doesn't exist, you can handle this scenario according to your business requirements
//                // For example, you can create a new account for the customer or log an error
//            	throw new BankAccountNotFoundException();
//            }
//        } else {
//			throw new CustomerNotFoundException();
//		}
//    }
    
    @Override
    public void deposit(Long customerId, Double amount) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            // Get the customer's account
            Account account = customer.getAccounts().get(0);

            // Check if the account exists
            if (account != null) {
                // Update the balance by adding the deposit amount
                double currentBalance = account.getBalance();
                double newBalance = currentBalance + amount;
                account.setBalance(newBalance);

                // Save the updated account to the database
                accountRepository.save(account);

                // Create a transaction entity
                Transaction transaction = new Transaction();
                transaction.setAmount(amount);
                transaction.setTransactionType("DEPOSIT");
                transaction.setTransactionDate(LocalDateTime.now());
                transaction.setCustomer(customer);

                // Save the transaction to the database
                transactionRepository.save(transaction);
            } else {
                // If the account doesn't exist, you can handle this scenario according to your business requirements
                // For example, you can create a new account for the customer or log an error
                throw new BankAccountNotFoundException();
            }
        } else {
            throw new CustomerNotFoundException();
        }
    }



//    @Override
//    public void withdraw(Long customerId, Double amount) {
//        // Retrieve the customer from the database
//        Customer customer = customerRepository.findById(customerId).orElse(null);
//        if (customer == null) {
//            // Handle case when customer is not found
//            // You can throw an exception or return an appropriate response
//            throw new CustomerNotFoundException();
//        }
//
//        // Get the customer's account
//        List<Account> accounts = customer.getAccounts();
//        Account account = accounts.get(0);
//
//        // Check if the account exists and has sufficient balance for withdrawal
//        if (account == null || (account.getBalance() - amount) < 0) {
//            // Handle case when account does not exist or balance is insufficient
//            // You can throw an exception or return an appropriate response
//            throw new InsufficientBalanceException();
//        }
//
//        // Perform the withdrawal by updating the account balance
//        Double updatedBalance = account.getBalance() - amount;
//        account.setBalance(updatedBalance);
//
//        // Save the updated account back to the database
//        accountRepository.save(account);
//    }
    
    @Override
    public void withdraw(Long customerId, Double amount) {
        // Retrieve the customer from the database
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            // Handle case when customer is not found
            // You can throw an exception or return an appropriate response
            throw new CustomerNotFoundException();
        }

        // Get the customer's account
        List<Account> accounts = customer.getAccounts();
        Account account = accounts.get(0);

        // Check if the account exists and has sufficient balance for withdrawal
        if (account == null || (account.getBalance() - amount) < 0) {
            // Handle case when account does not exist or balance is insufficient
            // You can throw an exception or return an appropriate response
            throw new InsufficientBalanceException();
        }

        // Perform the withdrawal by updating the account balance
        Double updatedBalance = account.getBalance() - amount;
        account.setBalance(updatedBalance);

        // Save the updated account back to the database
        accountRepository.save(account);

        // Create a transaction entity for the withdrawal
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionType("WITHDRAWAL");
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setCustomer(customer);

        // Save the transaction to the database
        transactionRepository.save(transaction);
    }


//    @Override
//    public void transfer(Long senderCustomerId, Long receiverCustomerId, Double amount) {
//        // Retrieve the sender and receiver customers from the database
//        Customer senderCustomer = customerRepository.findById(senderCustomerId).orElse(null);
//        Customer receiverCustomer = customerRepository.findById(receiverCustomerId).orElse(null);
//
//        // Check if both sender and receiver customers exist
//        if (senderCustomer == null || receiverCustomer == null) {
//            // Handle case when sender or receiver is not found
//            // You can throw an exception or return an appropriate response
//            if(senderCustomer == null) throw new CustomerNotFoundException("Sender Customer not found");
//            if(receiverCustomer == null) throw new CustomerNotFoundException("Receiver Customer not found");
//        }
//
//        // Get the sender and receiver accounts
//        Account senderAccount = senderCustomer.getAccounts().get(0);
//        Account receiverAccount = receiverCustomer.getAccounts().get(0);
//
//        // Check if the sender has sufficient balance for the transfer
//        if (senderAccount == null || senderAccount.getBalance() < amount) {
//            // Handle case when sender does not have sufficient balance
//            // You can throw an exception or return an appropriate response
//            throw new InsufficientBalanceException("Sender has insufficient balance");
//        }
//
//        // Subtract the transfer amount from the sender's account balance
//        senderAccount.setBalance(senderAccount.getBalance() - amount);
//
//        // Add the transfer amount to the receiver's account balance
//        receiverAccount.setBalance(receiverAccount.getBalance() + amount);
//
//        // Save the updated sender and receiver accounts back to the database
//        accountRepository.save(senderAccount);
//        accountRepository.save(receiverAccount);
//    }
    
    @Override
    public void transfer(Long senderCustomerId, Long receiverCustomerId, Double amount) {
        // Retrieve the sender and receiver customers from the database
        Customer senderCustomer = customerRepository.findById(senderCustomerId).orElse(null);
        Customer receiverCustomer = customerRepository.findById(receiverCustomerId).orElse(null);

        // Check if both sender and receiver customers exist
        if (senderCustomer == null || receiverCustomer == null) {
            // Handle case when sender or receiver is not found
            // You can throw an exception or return an appropriate response
            if(senderCustomer == null) throw new CustomerNotFoundException("Sender Customer not found");
            if(receiverCustomer == null) throw new CustomerNotFoundException("Receiver Customer not found");
        }

        // Get the sender and receiver accounts
        Account senderAccount = senderCustomer.getAccounts().get(0);
        Account receiverAccount = receiverCustomer.getAccounts().get(0);

        // Check if the sender has sufficient balance for the transfer
        if (senderAccount == null || senderAccount.getBalance() < amount) {
            // Handle case when sender does not have sufficient balance
            // You can throw an exception or return an appropriate response
            throw new InsufficientBalanceException("Sender has insufficient balance");
        }

        // Subtract the transfer amount from the sender's account balance
        senderAccount.setBalance(senderAccount.getBalance() - amount);

        // Add the transfer amount to the receiver's account balance
        receiverAccount.setBalance(receiverAccount.getBalance() + amount);

        // Save the updated sender and receiver accounts back to the database
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);

        // Record transaction for the transfer
        Transaction senderTransaction = new Transaction(null, -amount, "Transfer to " + receiverCustomer.getCustomerName(), LocalDateTime.now(), senderCustomer);
        Transaction receiverTransaction = new Transaction(null, amount, "Transfer from " + senderCustomer.getCustomerName(), LocalDateTime.now(), receiverCustomer);

        transactionRepository.save(senderTransaction);
        transactionRepository.save(receiverTransaction);
    }

    @Override
    public List<Transaction> getTransactionHistory(Long customerId) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        return transactions.stream()
                .map(transaction -> {
                    Transaction transactionDTO = new Transaction();
                    transactionDTO.setTransactionId(transaction.getTransactionId());
                    transactionDTO.setAmount(transaction.getAmount());
                    transactionDTO.setTransactionType(transaction.getTransactionType());
                    transactionDTO.setTransactionDate(transaction.getTransactionDate());
                    return transactionDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Resource downloadBankStatement(Long customerId) {
        // Implement logic to generate and download bank statement
        return null;
    }

}
