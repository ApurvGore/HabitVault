//package com.habitvault.controller;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.habitvault.dto.TransactionDTO;
//import com.habitvault.entity.Account;
//import com.habitvault.entity.Customer;
//import com.habitvault.service.CustomerServiceImpl;
//
//@RestController
//@RequestMapping("/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerServiceImpl customerService;
//
//    // Endpoint for viewing own account details
//    @GetMapping("/accountDetails/{customerId}")
//    public Optional<Account> getAccountDetails(@PathVariable Long customerId) {
//        return customerService.getAccountDetails(customerId);
//    }
//    
//    // Endpoint for adding account details
//    @PostMapping("/{customerId}/addAccount")
//    public ResponseEntity<String> addAccount(@RequestBody Account account, @PathVariable Long customerId) {
//        Customer customer = customerService.getCustomerById(customerId);
//        if (customer == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
//        }
//        account.setCustomer(customer);
//        customerService.addAccount(account);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Account added successfully");
//    }
//
//    // Endpoints for performing account transactions
//    // Perform account deposit
//    @PostMapping("/deposit")
//    public void deposit(@RequestParam Long customerId, @RequestParam BigDecimal amount) {
//        customerService.deposit(customerId, amount);
//    }
//
//    // Perform account withdrawal
//    @PostMapping("/withdraw")
//    public void withdraw(@RequestParam Long customerId, @RequestParam BigDecimal amount) {
//        customerService.withdraw(customerId, amount);
//    }
//
//    // Perform account transfer
//    @PostMapping("/transfer")
//    public void transfer(@RequestParam Long senderCustomerId, @RequestParam Long receiverCustomerId, @RequestParam BigDecimal amount) {
//        customerService.transfer(senderCustomerId, receiverCustomerId, amount);
//    }
//
//    // Endpoint for viewing transaction history
//    @GetMapping("/transactionHistory/{customerId}")
//    public List<TransactionDTO> getTransactionHistory(@PathVariable Long customerId) {
//        return customerService.getTransactionHistory(customerId);
//    }
//
//    // Endpoint for downloading account statements
////    @GetMapping("/accountStatements/{customerId}")
////    public ResponseEntity<Resource> downloadAccountStatement(@PathVariable Long customerId) {
////        // Implement logic to generate and download account statements
////    }
//}
//
//


package com.habitvault.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.habitvault.dto.AccountDTO;
import com.habitvault.dto.TransactionDTO;
import com.habitvault.entity.Account;
import com.habitvault.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    // Endpoint for viewing own account details
    @GetMapping("/accountDetails")
    public Optional<Account> getAccountDetails() {
        // Assume customer is logged in and their ID is retrieved from authentication
        Long customerId = 1L; // Example customer ID, replace with actual logged-in customer ID
        return customerService.getAccountDetails(customerId);
    }
    
    // Endpoint for adding account details - tested -> working properly; but enum value stored as a digit in the database
    @PostMapping("/addAccount")
    public ResponseEntity<String> addAccount(@RequestBody AccountDTO accountDTO) {
    	
        // Assume customer is logged in and their ID is retrieved from authentication
//        Customer customer = customerService.getCustomerByName(accountDTO.getCustomerName());
//        if (customer == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
//        } else {
//        accountDTO.setCustomer(customer);
        // at this point, customer already exists, so there is only one task to do, 
        // add and bind the account to the customer
        customerService.addAccount(accountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account added successfully for customer " + accountDTO.getCustomerName());
//        }
    }

    // Endpoints for performing account transactions
    // Perform account deposit
    @PostMapping("/deposit")
    public void deposit(@RequestParam Double amount) {
        // Assume customer is logged in and their ID is retrieved from authentication
        Long customerId = 1L; // Example customer ID, replace with actual logged-in customer ID
        customerService.deposit(customerId, amount);
    }

    // Perform account withdrawal
    @PostMapping("/withdraw")
    public void withdraw(@RequestParam Double amount) {
        // Assume customer is logged in and their ID is retrieved from authentication
        Long customerId = 1L; // Example customer ID, replace with actual logged-in customer ID
        customerService.withdraw(customerId, amount);
    }

    // Perform account transfer
    @PostMapping("/transfer")
    public void transfer(@RequestParam Long receiverCustomerId, @RequestParam Double amount) {
        // Assume customer is logged in and their ID is retrieved from authentication
        Long senderCustomerId = 1L; // Example customer ID, replace with actual logged-in customer ID
        customerService.transfer(senderCustomerId, receiverCustomerId, amount);
    }

    // Endpoint for viewing transaction history
    @GetMapping("/transactionHistory")
    public List<TransactionDTO> getTransactionHistory() {
        // Assume customer is logged in and their ID is retrieved from authentication
        Long customerId = 1L; // Example customer ID, replace with actual logged-in customer ID
        return customerService.getTransactionHistory(customerId);
    }

    // Endpoint for downloading account statements
//    @GetMapping("/accountStatements")
//    public ResponseEntity<Resource> downloadAccountStatement() {
//        // Implement logic to generate and download account statements
//    }
}
