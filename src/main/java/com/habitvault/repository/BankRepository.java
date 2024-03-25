package com.habitvault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habitvault.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

	Bank findByName(String bankName);
    // Add custom query methods if needed
}
