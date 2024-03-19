package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.BankDTO;
import com.example.demo.dto.BankManagerDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Bank;
import com.example.demo.entity.BankManager;
import com.example.demo.entity.Customer;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.BankManagerRepository;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.CustomerRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private BankManagerRepository bankManagerRepository;
    
    @Autowired
    private BankRepository bankRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    public void register(Admin admin) {
        // Convert AdminDTO to Admin entity
//        Admin admin = convertToEntity(adminDTO);
        
        // Perform any additional business logic/validation
        
        // Save the admin entity to the database
        adminRepository.save(admin);
    }

    // Convert AdminDTO to Admin entity
    private Admin convertToEntity(AdminDTO adminDTO) {
        Admin admin = new Admin();
        // Set properties of the admin entity from adminDTO
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        // Set other properties
        
        return admin;
    }

    // Other methods for bank management, customer management, etc.
    
    @Override
    public void addBank(Bank bank) {
        // Add logic to add a bank
        bankRepository.save(bank);
    }
    
    @Override
    public void addBankManager(BankManagerDTO bankManagerDTO) throws ResourceNotFoundException {
        // Convert BankManagerDTO to BankManager entity
        BankManager bankManager = new BankManager();
        bankManager.setName(bankManagerDTO.getManagerName());
        bankManager.setEmail(bankManagerDTO.getEmail());
        // Set other properties as needed

        try {
            // Save the bank manager entity to the database
            bankManagerRepository.save(bankManager);
        } catch (Exception e) {
            // Handle any exceptions (e.g., database errors)
            // You can log the error or throw a custom exception
            // For example:
            throw new ResourceNotFoundException("Failed to add bank manager", e);
        }
    }
    
    @Override
    public List<BankManager> getAllBankManagers() {
        return bankManagerRepository.findAll();
    }
    
    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

	@Override
	public List<Customer> getAllCustomers() {
	    return customerRepository.findAll();
	}
	
	@Override
	public List<Account> getCustomerAccounts(Long customerId) {
	    return accountRepository.findByCustomerId(customerId);
	}
	
	@Override
	public Customer getCustomerDetails(Long customerId) {
	    Optional<Customer> customerOptional = customerRepository.findById(customerId);
	    if (customerOptional.isPresent()) {
	        return customerOptional.get();
	    } else {
	        throw new ResourceNotFoundException("Customer not found with ID: " + customerId);
	    }
	}


}
