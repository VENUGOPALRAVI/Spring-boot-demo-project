package com.BankingApplication.BankingApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApplication.BankingApplication.Config.ResponseStructure;
import com.BankingApplication.BankingApplication.Service.BranchService;
import com.BankingApplication.BankingApplication.dto.Branch;

@RestController
@RequestMapping("/branch")
public class BranchController 
{
	@Autowired
	BranchService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch( @RequestBody  Branch b,@RequestParam int bankid)
	{
		return service.saveBranch(b, bankid);
		
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Branch>> findBranch( @RequestParam int branchid)
	{
		return service.findBranch(branchid);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Branch>> updateBranch( @RequestBody   Branch b,@RequestParam int branchid)
	{
		return service.updateBranch(b, branchid);
	}
	

}
