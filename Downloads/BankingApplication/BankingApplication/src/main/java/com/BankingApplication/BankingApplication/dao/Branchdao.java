package com.BankingApplication.BankingApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankingApplication.BankingApplication.Repository.Branchrepo;
import com.BankingApplication.BankingApplication.dto.Bank;
import com.BankingApplication.BankingApplication.dto.Branch;

@Repository
public class Branchdao 
{
	@Autowired
	Branchrepo repo;
	
	public Branch saveBranch(Branch b)
	{
		return repo.save(b);
		
	}
	
	public Branch findBranch(int id)
	{
		Optional<Branch> branch= repo.findById(id);
		return branch.get();
	}
	
	public Branch deleteBranch(int id)
	{
		Branch exbranch =findBranch(id);
		if(exbranch!=null)
		{
			repo.delete(exbranch);
			return exbranch;
		}
		return null;
	}
	
	public List<Branch> findAllBranch()
	{
		return repo.findAll();
	}
	
	public Branch updateBranch(Branch b,int id)
	{
		Branch exbranch = findBranch(id);
		if(exbranch!=null)
		{
			if(b.getId()==0)
			{
				b.setId(exbranch.getId());
			}
			if(b.getIFSC()==null)
			{
				b.setIFSC(exbranch.getIFSC());
			}
			if(b.getManager()==null)
			{
				b.setManager(exbranch.getManager());;
			}
			if(b.getBank()==null)
			{
				b.setBank(exbranch.getBank());;
			}
			if(b.getAddress()==null)
			{
				b.setAddress(exbranch.getAddress());
			}
			if(b.getUser()==null)
			{
				b.setUser(exbranch.getUser());
			}
			return repo.save(b);
		}
		return null;
	}
	
	

}
