package com.BankingApplication.BankingApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankingApplication.BankingApplication.Repository.AccountRepo;
import com.BankingApplication.BankingApplication.dto.Account;
import com.BankingApplication.BankingApplication.dto.Bank;

@Repository
public class Accountdao 
{
	@Autowired
	AccountRepo repo;
	
	public Account saveAccount(Account a)
	{
		return repo.save(a);
		
	}
	
	public Account findAccount(int id)
	{
		Optional<Account> account= repo.findById(id);
		return account.get();
	}
	
	public Account deleteAccount(int id)
	{
		Account exAccount =findAccount(id);
		if(exAccount!=null)
		{
			repo.delete(exAccount);
			return exAccount;
		}
		return null;
	}
	
	public List<Account> findAllAccount()
	{
		return repo.findAll();
	}
	
	public Account updateAccount(Account a,int id)
	{
		Account exaccount = findAccount(id);
		if(exaccount!=null)
		{
			if(a.getId()==0)
			{
			    a.setId(exaccount.getId());;
			}
			if(a.getPassword()==null)
			{
				a.setPassword(exaccount.getPassword());;
			}
			if(a.getAccountNumber()==0)
			{
				a.setAccountNumber(exaccount.getAccountNumber());;
			}
			if(a.getAccounttype()==null)
			{
				a.setAccounttype(exaccount.getAccounttype());;
			}
			if(a.getBalance()==0.0)
			{
				a.setBalance(exaccount.getBalance());
			}
			if(a.getTransaction()==null)
			{
				a.setTransaction(exaccount.getTransaction());
			}
			return repo.save(a);
		}
		return null;
	}


}
