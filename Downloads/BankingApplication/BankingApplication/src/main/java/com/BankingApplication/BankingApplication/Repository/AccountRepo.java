package com.BankingApplication.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApplication.BankingApplication.dto.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>
{

}
