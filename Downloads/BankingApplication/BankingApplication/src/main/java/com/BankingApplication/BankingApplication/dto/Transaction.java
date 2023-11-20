package com.BankingApplication.BankingApplication.dto;

import java.util.Date;

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
public class Transaction 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double Amount;
	@OneToOne
	private Account toAccount;
	private Date datetime;
	private TransactionType transactiontype;
	private TransactionStatus transactionStatus;
	

}
