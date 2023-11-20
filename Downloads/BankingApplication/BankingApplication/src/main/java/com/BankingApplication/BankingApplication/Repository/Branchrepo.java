package com.BankingApplication.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApplication.BankingApplication.dto.Branch;

public interface Branchrepo extends JpaRepository<Branch, Integer>
{

}
