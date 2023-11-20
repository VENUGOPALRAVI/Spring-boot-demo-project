package com.BankingApplication.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApplication.BankingApplication.dto.User;

public interface Userrepo extends JpaRepository<User, Integer>
{
	
	

}
