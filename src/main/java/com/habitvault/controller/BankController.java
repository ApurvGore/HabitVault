package com.habitvault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.habitvault.entity.Account;
import com.habitvault.entity.Customer;
import com.habitvault.entity.Transaction;
import com.habitvault.service.BankServiceImpl;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankServiceImpl bankService;

    // Endpoint for registering customers - tested -> working properly
    @PostMapping("/registerCustomer") 
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        bankService.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body("Customer registered successfully");
    }

    // Endpoints for managing bank customers
    // Get all bank customers  - tested -> working properly
    @GetMapping("/customers")
    public List<Customer> getAllBankCustomers() {
        return bankService.getAllBankCustomers();
    }

    // Endpoint for managing bank accounts
    // Get all bank accounts  - tested -> working properly
    @GetMapping("/accounts")
    public List<Account> getAllBankAccounts() {
        return bankService.getAllBankAccounts();
    }

    // Endpoints for performing bank transactions
    // Perform bank deposit - tested -> working properly
    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam Long customerId, @RequestParam Double amount) {
        bankService.deposit(customerId, amount);
        return ResponseEntity.status(HttpStatus.OK).body("Amount deposited successfully");
    }

    // Perform bank withdrawal - tested -> working properly
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam Long customerId, @RequestParam Double amount) {
        bankService.withdraw(customerId, amount);
        return ResponseEntity.status(HttpStatus.OK).body("Amount withdrawn successfully");
    }

    // Perform bank transfer - tested -> working properly
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Long senderCustomerId, @RequestParam Long receiverCustomerId, @RequestParam Double amount) {
        bankService.transfer(senderCustomerId, receiverCustomerId, amount);
        return ResponseEntity.status(HttpStatus.OK).body("Amount transferred successfully");
    }

    // Endpoints for viewing transaction history
    // Get transaction history for a customer
    @GetMapping("/transactionHistory/{customerId}")
    public List<Transaction> getTransactionHistory(@PathVariable Long customerId) {
        return bankService.getTransactionHistory(customerId);
    }

    // Endpoint for downloading bank statements
//    @GetMapping("/bankStatements/{customerId}")
//    public ResponseEntity<Resource> downloadBankStatement(@PathVariable Long customerId) {
//        // Implement logic to generate and download bank statements
//    }
}
