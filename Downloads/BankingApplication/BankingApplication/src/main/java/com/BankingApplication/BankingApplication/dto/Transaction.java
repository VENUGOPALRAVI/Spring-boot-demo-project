package com.BankingApplication.BankingApplication.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Transaction 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double Amount;
	@ManyToOne
	private Account toAccount;
	private Date datetime;
	private TransactionType transactiontype;
	private TransactionStatus transactionStatus;
	

}
