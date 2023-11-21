package com.BankingApplication.BankingApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankingApplication.BankingApplication.Repository.Userrepo;
import com.BankingApplication.BankingApplication.dto.Bank;
import com.BankingApplication.BankingApplication.dto.User;

@Repository
public class Userdao 
{
	@Autowired
	Userrepo repo;
	
	public User saveUser(User u)
	{
		return repo.save(u);
		
	}
	
	public User findUser(int id)
	{
		Optional<User> user= repo.findById(id);
		return user.get();
	}
	
	public User deleteUser(int id)
	{
		User exuser =findUser(id);
		if(exuser!=null)
		{
			repo.delete(exuser);
			return exuser;
		}
		return null;
	}
	
	public List<User> findAllBank()
	{
		return repo.findAll();
	}
	
	public User updateUser(User u,int id)
	{
		User exuser = findUser(id);
		if(exuser!=null)
		{
			if(u.getName()==null)
			{
				u.setName(exuser.getName());
			}
			if(u.getAddress()==null)
			{
				u.setAddress(exuser.getAddress());
			}
			if(u.getAccount()==null)
			{
				u.setAccount(exuser.getAccount());;
			}
			if(u.getBranch()==null)
			{
				u.setBranch(exuser.getBranch());
			}
			u.setId(exuser.getId());
			return repo.save(u);
		}
		return null;
	}

	
	

}
