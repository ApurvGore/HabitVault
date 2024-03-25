package com.habitvault.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.habitvault.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findById(Long customerId);
    // You can add custom query methods here if needed
	
	@Query("SELECT a FROM Account a WHERE a.customer.id = :customerId")
	List<Account> findByCustomerId(Long customerId);
}
