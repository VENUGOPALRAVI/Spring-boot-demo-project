package com.BankingApplication.BankingApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankingApplication.BankingApplication.Repository.Bank_repo;
import com.BankingApplication.BankingApplication.dto.Bank;

@Repository
public class Bankdao 
{
	@Autowired
	Bank_repo repo;
	
	public Bank saveBank(Bank b)
	{
		return repo.save(b);
		
	}
	
	public Bank findBank(int id)
	{
		Optional<Bank> bank= repo.findById(id);
		return bank.get();
	}
	
	public Bank deleteBank(int id)
	{
		Bank exbank =findBank(id);
		if(exbank!=null)
		{
			repo.delete(exbank);
			return exbank;
		}
		return null;
	}
	
	public List<Bank> findAllBank()
	{
		return repo.findAll();
	}
	
	public Bank updateBank(Bank b,int id)
	{
		Bank exbank = findBank(id);
		if(exbank!=null)
		{
			if(b.getId()==0)
			{
				b.setId(exbank.getId());
			}
			if(b.getName()==null)
			{
				b.setName(exbank.getName());
			}
			if(b.getContact()==0)
			{
				b.setContact(exbank.getContact());
			}
			if(b.getBranches()==null)
			{
				b.setBranches(exbank.getBranches());
			}
			return repo.save(b);
		}
		return null;
	}

}
