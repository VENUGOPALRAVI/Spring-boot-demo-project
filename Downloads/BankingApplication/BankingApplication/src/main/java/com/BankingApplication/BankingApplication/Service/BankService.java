package com.BankingApplication.BankingApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankingApplication.BankingApplication.Config.ResponseStructure;
import com.BankingApplication.BankingApplication.dao.Bankdao;
import com.BankingApplication.BankingApplication.dto.Bank;
import com.BankingApplication.BankingApplication.dto.Branch;

@Service
public class BankService 
{
	@Autowired
	Bankdao dao;
	
	public ResponseEntity<ResponseStructure<Bank>> saveBank(Bank b)
	{
		ResponseStructure<Bank> structure = new ResponseStructure<Bank>();
		structure.setData(dao.saveBank(b));
		structure.setMessage("bank is saved");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Bank>>(structure,HttpStatus.CREATED);
		
		
	}
	public ResponseEntity<ResponseStructure<Bank>> findBank(int id)
	{
		ResponseStructure<Bank> structure = new ResponseStructure<Bank>();
		structure.setData(dao.findBank(id));
		structure.setMessage("bank is found");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Bank>>(structure,HttpStatus.FOUND);
		
		
	}
	
	public ResponseEntity<ResponseStructure<Bank>> updateBank(Bank b,int bankId)
	{
		ResponseStructure<Bank> structure = new ResponseStructure<Bank>();
		structure.setData( dao.updateBank(b, bankId));
		structure.setMessage("bank data updated");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Bank>>(structure,HttpStatus.OK);
		
	}

}
