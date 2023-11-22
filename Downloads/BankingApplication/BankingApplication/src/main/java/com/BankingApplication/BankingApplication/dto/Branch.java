package com.BankingApplication.BankingApplication.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Branch 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String IFSC;
	@OneToOne(cascade = CascadeType.ALL)
	private Manager manager;
	@ManyToOne(cascade = CascadeType.ALL)
	private Bank bank;
	@OneToMany(cascade = CascadeType.ALL)
	private  List<User>user;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

}
