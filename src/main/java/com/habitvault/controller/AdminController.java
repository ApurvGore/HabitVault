package com.habitvault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.habitvault.dto.BankManagerDTO;
import com.habitvault.entity.Account;
import com.habitvault.entity.Admin;
import com.habitvault.entity.Bank;
import com.habitvault.entity.Customer;
import com.habitvault.exception.BankNotFoundException;
import com.habitvault.service.AdminServiceImpl;

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

    // Endpoints for bank management 
    // Add a bank - tested -> working
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

    // Add a bank manager - tested -> working
    @PostMapping("/addBankManager")
    public ResponseEntity<String> addBankManager(@RequestBody BankManagerDTO bankManagerDTO) {
        try {
			adminService.addBankManager(bankManagerDTO);
		} catch (BankNotFoundException e) {
			System.err.println(e.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
        return ResponseEntity.status(HttpStatus.CREATED).body("Bank Manager added successfully");
    }

    // Get all bank managers - tested -> working
    @GetMapping("/bankManagers")
    public List<BankManagerDTO> getAllBankManagers() {
        return adminService.getAllBankManagers();
    }

    
    // Endpoints for viewing customers across banks and managing customer details
    // Get all customers - tested -> working
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }
    


    // Get customer details by customerId - tested -> working  
    @GetMapping("/customers/{customerId}")
    public Customer getCustomerDetails(@PathVariable Long customerId) {
        return adminService.getCustomerDetails(customerId);
    }
    


    // Get customer accounts by customerId - tested -> working  
    @GetMapping("/customers/{customerId}/accounts")
    public List<Account> getCustomerAccounts(@PathVariable Long customerId) {
        return adminService.getCustomerAccounts(customerId);
    }
    
    // DONE TILL HERE


    // Endpoint for downloading bank statements
//    @GetMapping("/bankStatements/{customerId}")
//    public ResponseEntity<Resource> downloadBankStatement(@PathVariable Long customerId) {
//        // Implement logic to generate and download bank statements
//    }
}
