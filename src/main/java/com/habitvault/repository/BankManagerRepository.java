package com.habitvault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habitvault.entity.BankManager;

@Repository
public interface BankManagerRepository extends JpaRepository<BankManager, Long> {
    // You can add custom query methods here if needed
}
