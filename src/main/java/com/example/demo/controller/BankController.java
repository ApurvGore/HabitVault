package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.dto.AccountDTO;
import com.example.demo.service.BankServiceImpl;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankServiceImpl bankService;

    // Endpoint for registering customers
    @PostMapping("/registerCustomer")
    public void registerCustomer(@RequestBody CustomerDTO customerDTO) {
        bankService.registerCustomer(customerDTO);
    }

    // Endpoints for managing bank customers
    // Get all bank customers
    @GetMapping("/customers")
    public List<CustomerDTO> getAllBankCustomers() {
        return bankService.getAllBankCustomers();
    }

    // Endpoint for managing bank accounts
    // Get all bank accounts
    @GetMapping("/accounts")
    public List<AccountDTO> getAllBankAccounts() {
        return bankService.getAllBankAccounts();
    }

    // Endpoints for performing bank transactions
    // Perform bank deposit
    @PostMapping("/deposit")
    public void deposit(@RequestParam Long customerId, @RequestParam BigDecimal amount) {
        bankService.deposit(customerId, amount);
    }

    // Perform bank withdrawal
    @PostMapping("/withdraw")
    public void withdraw(@RequestParam Long customerId, @RequestParam BigDecimal amount) {
        bankService.withdraw(customerId, amount);
    }

    // Perform bank transfer
    @PostMapping("/transfer")
    public void transfer(@RequestParam Long senderCustomerId, @RequestParam Long receiverCustomerId, @RequestParam BigDecimal amount) {
        bankService.transfer(senderCustomerId, receiverCustomerId, amount);
    }

    // Endpoints for viewing transaction history
    // Get transaction history for a customer
    @GetMapping("/transactionHistory/{customerId}")
    public List<TransactionDTO> getTransactionHistory(@PathVariable Long customerId) {
        return bankService.getTransactionHistory(customerId);
    }

    // Endpoint for downloading bank statements
//    @GetMapping("/bankStatements/{customerId}")
//    public ResponseEntity<Resource> downloadBankStatement(@PathVariable Long customerId) {
//        // Implement logic to generate and download bank statements
//    }
}
