package com.BankingApplication.BankingApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankingApplication.BankingApplication.Config.ResponseStructure;
import com.BankingApplication.BankingApplication.dao.Branchdao;
import com.BankingApplication.BankingApplication.dao.Managerdao;
import com.BankingApplication.BankingApplication.dto.Bank;
import com.BankingApplication.BankingApplication.dto.Branch;
import com.BankingApplication.BankingApplication.dto.Manager;

@Service
public class ManagerService 
{
	@Autowired
	Managerdao dao;
	
	@Autowired
	Branchdao bdao;
	
	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager m,int branchId)
	{
		ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
		
		Branch exbranch = bdao.findBranch(branchId);
		Manager savedManager= dao.saveManager(m);
		exbranch.setManager(savedManager);
		savedManager.setBranch(exbranch);
		dao.updateManager(savedManager, branchId);
		
		structure.setData(savedManager);
		structure.setMessage("manager is saved");
		structure.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Manager>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Manager>> findManager(int id)
	{
		ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
		structure.setData(dao.findManager(id));
		structure.setMessage("bank is found");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Manager>>(structure,HttpStatus.FOUND);
		
		
	}
	
	public ResponseEntity<ResponseStructure<Manager>> updateManager(Manager m,int managerId)
	{
		ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
		structure.setData( dao.updateManager(m, managerId));
		structure.setMessage("branch data updated");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Manager>>(structure,HttpStatus.OK);
		
	}

	

}
