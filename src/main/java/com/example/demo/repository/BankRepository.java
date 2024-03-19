package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    // Add custom query methods if needed
}