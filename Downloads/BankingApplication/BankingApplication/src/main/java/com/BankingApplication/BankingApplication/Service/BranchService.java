package com.BankingApplication.BankingApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankingApplication.BankingApplication.Config.ResponseStructure;
import com.BankingApplication.BankingApplication.dao.Bankdao;
import com.BankingApplication.BankingApplication.dao.Branchdao;
import com.BankingApplication.BankingApplication.dto.Bank;
import com.BankingApplication.BankingApplication.dto.Branch;

@Service
public class BranchService
{
	@Autowired
	Branchdao dao;
	
	@Autowired
	Bankdao bankdao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch b,int bankId)
	{
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		Bank exbank= bankdao.findBank(bankId);
		b.setBank(exbank);
		
		structure.setData(dao.saveBranch(b));
		structure.setMessage("branch is saved");
		structure.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Branch>> (structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> findBranch(int branchId)
	{
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		structure.setData(dao.findBranch(branchId));
		structure.setMessage("branch is found");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
		
		
	}
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch b,int branchId)
	{
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		structure.setData( dao.updateBranch(b, branchId));
		structure.setMessage("branch data updated");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		
	}

}
