package com.BankingApplication.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApplication.BankingApplication.dto.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> 
{

}
