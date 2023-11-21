package com.BankingApplication.BankingApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankingApplication.BankingApplication.Repository.TransactionRepo;
import com.BankingApplication.BankingApplication.dto.Bank;
import com.BankingApplication.BankingApplication.dto.Transaction;

@Repository
public class Transactiondao
{
	@Autowired
	TransactionRepo repo;
	
	public Transaction saveTransaction(Transaction t)
	{
		return repo.save(t);
		
	}
	
	public Transaction findTransaction(int id)
	{
		Optional<Transaction> trans= repo.findById(id);
		return trans.get();
	}
	
	public Transaction deleteTransaction(int id)
	{
		Transaction extransaction =findTransaction(id);
		if(extransaction!=null)
		{
			repo.delete(extransaction);
			return extransaction;
		}
		return null;
	}
	
	public List<Transaction> findAllTransaction()
	{
		return repo.findAll();
	}
	
	public Transaction updateTransaction(Transaction t,int id)
	{
		Transaction extrans = findTransaction(id);
		if(extrans!=null)
		{
			if(t.getId()==0)
			{
				t.setId(extrans.getId());
			}
			if(t.getAmount()==0.0)
			{
				t.setAmount(extrans.getAmount());
			}
			if(t.getToAccount()==null)
			{
				t.setToAccount(extrans.getToAccount());;
			}
			if(t.getDatetime()==null)
			{
				t.setDatetime(extrans.getDatetime());;
			}
			if(t.getTransactiontype()==null)
			{
				t.setTransactiontype(extrans.getTransactiontype());
			}
			if(t.getTransactionStatus()==null)
			{
				t.setTransactionStatus(extrans.getTransactionStatus());
			}
			
			return repo.save(t);
		}
		return null;
	}

	
	

}
