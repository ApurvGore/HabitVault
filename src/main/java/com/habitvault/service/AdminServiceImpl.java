package com.habitvault.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habitvault.dto.BankManagerDTO;
import com.habitvault.entity.Account;
import com.habitvault.entity.Admin;
import com.habitvault.entity.Bank;
import com.habitvault.entity.BankManager;
import com.habitvault.entity.Customer;
import com.habitvault.exception.BankAlreadyExistsException;
import com.habitvault.exception.BankNotFoundException;
import com.habitvault.exception.ResourceNotFoundException;
import com.habitvault.repository.AccountRepository;
import com.habitvault.repository.AdminRepository;
import com.habitvault.repository.BankManagerRepository;
import com.habitvault.repository.BankRepository;
import com.habitvault.repository.CustomerRepository;

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
        adminRepository.save(admin);
    }

    

    // Other methods for bank management, customer management, etc.
    
    @Override
    public void addBank(Bank bank) {
    	Bank existingBank = bankRepository.findByName(bank.getName());
    	if(existingBank == null) bankRepository.save(bank);
    	else throw new BankAlreadyExistsException();
    }
    
    @Override
    public void addBankManager(BankManagerDTO bankManagerDTO) throws BankNotFoundException { 
    	Bank fetchedBank = bankRepository.findByName(bankManagerDTO.getBankName());
    	if(fetchedBank != null) {
    		BankManager bankManager = new BankManager(bankManagerDTO.getName(), bankManagerDTO.getEmail(), bankManagerDTO.getPhoneNumber(), fetchedBank);
            bankManagerRepository.save(bankManager);
    	} else {
			throw new BankNotFoundException("Add the bank first");
		}
    }
    
    @Override
    public List<BankManagerDTO> getAllBankManagers() {
        List<BankManager> listOfBankManagers = bankManagerRepository.findAll();
        return listOfBankManagers.stream() // list to stream
        .map(b -> { return new BankManagerDTO(b.getName(), b.getEmail(), b.getPhoneNumber(), b.getBank() != null ? b.getBank().getName() : null);})
        .collect(Collectors.toList()); // stream to list
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
