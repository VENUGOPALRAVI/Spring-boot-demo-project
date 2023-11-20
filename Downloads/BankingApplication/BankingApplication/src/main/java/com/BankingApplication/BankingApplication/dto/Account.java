package com.BankingApplication.BankingApplication.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long AccountNumber;
	private String password;
	@OneToOne
	private AccountType accounttype;
	@OneToOne
	private User user;
	private int balance;
	@OneToOne
	private Transaction transaction;
	

}
