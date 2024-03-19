package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    // Endpoint for viewing own account details
    @GetMapping("/accountDetails/{customerId}")
    public AccountDTO getAccountDetails(@PathVariable Long customerId) {
        return customerService.getAccountDetails(customerId);
    }

    // Endpoints for performing account transactions
    // Perform account deposit
    @PostMapping("/deposit")
    public void deposit(@RequestParam Long customerId, @RequestParam BigDecimal amount) {
        customerService.deposit(customerId, amount);
    }

    // Perform account withdrawal
    @PostMapping("/withdraw")
    public void withdraw(@RequestParam Long customerId, @RequestParam BigDecimal amount) {
        customerService.withdraw(customerId, amount);
    }

    // Perform account transfer
    @PostMapping("/transfer")
    public void transfer(@RequestParam Long senderCustomerId, @RequestParam Long receiverCustomerId, @RequestParam BigDecimal amount) {
        customerService.transfer(senderCustomerId, receiverCustomerId, amount);
    }

    // Endpoint for viewing transaction history
    @GetMapping("/transactionHistory/{customerId}")
    public List<TransactionDTO> getTransactionHistory(@PathVariable Long customerId) {
        return customerService.getTransactionHistory(customerId);
    }

    // Endpoint for downloading account statements
//    @GetMapping("/accountStatements/{customerId}")
//    public ResponseEntity<Resource> downloadAccountStatement(@PathVariable Long customerId) {
//        // Implement logic to generate and download account statements
//    }
}
