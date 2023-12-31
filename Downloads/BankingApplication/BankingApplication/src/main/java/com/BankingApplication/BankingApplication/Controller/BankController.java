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
import com.BankingApplication.BankingApplication.Service.BankService;
import com.BankingApplication.BankingApplication.dto.Bank;

@RestController
@RequestMapping("/bank")
public class BankController 
{
	@Autowired
	BankService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Bank>> saveBank(@RequestBody Bank b)
	{
		return service.saveBank(b);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Bank>>findBank(@RequestParam int bankId)
	{
		return service.findBank(bankId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Bank>> updateBank(@RequestBody  Bank b,@RequestParam int id)
	{
		return service.updateBank(b, id);
	}
	

}
