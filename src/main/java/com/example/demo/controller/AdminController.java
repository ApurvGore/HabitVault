package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.BankDTO;
import com.example.demo.dto.BankManagerDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Bank;
import com.example.demo.entity.BankManager;
import com.example.demo.entity.Customer;
import com.example.demo.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    // Endpoint for user registration - tested -> working
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Admin admin) {
        adminService.register(admin);
        return ResponseEntity.status(HttpStatus.OK).body("Admin registered successfully");
    }

    // Endpoints for bank management - tested -> working
    // Add a bank
    @PostMapping("/addBank")
    public ResponseEntity<String> addBank(@RequestBody Bank bank) {
        adminService.addBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bank added successfully");
    }

    // Get all banks - tested -> working
    @GetMapping("/getBanks")
    public List<Bank> getAllBanks() {
        return adminService.getAllBanks();
    }

    // Add a bank manager
    @PostMapping("/bankManagers")
    public void addBankManager(@RequestBody BankManagerDTO bankManagerDTO) {
        adminService.addBankManager(bankManagerDTO);
    }

    // Get all bank managers
    @GetMapping("/bankManagers")
    public List<BankManager> getAllBankManagers() {
        return adminService.getAllBankManagers();
    }

    // Endpoints for viewing customers across banks and managing customer details
    // Get all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    // Get customer details by customerId
    @GetMapping("/customers/{customerId}")
    public Customer getCustomerDetails(@PathVariable Long customerId) {
        return adminService.getCustomerDetails(customerId);
    }

    // Get customer accounts by customerId
    @GetMapping("/customers/{customerId}/accounts")
    public List<Account> getCustomerAccounts(@PathVariable Long customerId) {
        return adminService.getCustomerAccounts(customerId);
    }

    // Endpoint for downloading bank statements
//    @GetMapping("/bankStatements/{customerId}")
//    public ResponseEntity<Resource> downloadBankStatement(@PathVariable Long customerId) {
//        // Implement logic to generate and download bank statements
//    }
}
