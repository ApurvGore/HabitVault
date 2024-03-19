package com.example.demo.repository;

import com.example.demo.entity.BankManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankManagerRepository extends JpaRepository<BankManager, Long> {
    // You can add custom query methods here if needed
}
