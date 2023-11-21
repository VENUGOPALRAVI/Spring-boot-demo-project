package com.BankingApplication.BankingApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankingApplication.BankingApplication.Repository.Managerrepo;
import com.BankingApplication.BankingApplication.dto.Bank;
import com.BankingApplication.BankingApplication.dto.Manager;

@Repository
public class Managerdao 
{
	@Autowired
	Managerrepo repo;
	
	public Manager saveManager(Manager m)
	{
		return repo.save(m);
		
	}
	
	public Manager findManager(int id)
	{
		Optional<Manager> manager= repo.findById(id);
		return manager.get();
	}
	
	public Manager deleteManager(int id)
	{
		Manager exmanager =findManager(id);
		if(exmanager!=null)
		{
			repo.delete(exmanager);
			return exmanager;
		}
		return null;
	}
	
	public List<Manager> findAllManager()
	{
		return repo.findAll();
	}
	
	public Manager updateManager(Manager m,int id)
	{
		Manager exmanager = findManager(id);
		if(exmanager!=null)
		{
			if(m.getId()==0)
			{
				m.setId(exmanager.getId());
			}
			if(m.getName()==null)
			{
				m.setName(exmanager.getName());;
			}
			if(m.getPassword()==null)
			{
				m.setPassword(exmanager.getPassword());;
			}
			if(m.getBranch()==null)
			{
				m.setBranch(exmanager.getBranch());;
			}
			if(m.getAddress()==null)
			{
				m.setAddress(exmanager.getAddress());
			}
			return repo.save(m);
		}
		return null;
	}


}
