package com.BankingApplication.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApplication.BankingApplication.dto.Manager;

public interface Managerrepo extends JpaRepository<Manager, Integer>
{

}
