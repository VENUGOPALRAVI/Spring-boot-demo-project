package com.BankingApplication.BankingApplication.Config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T>
{
	private int Status;
	private String Message;
	private T data;
	
	

}
