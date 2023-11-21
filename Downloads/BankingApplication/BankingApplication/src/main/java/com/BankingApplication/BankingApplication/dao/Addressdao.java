package com.BankingApplication.BankingApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankingApplication.BankingApplication.Repository.AddressRepo;
import com.BankingApplication.BankingApplication.dto.Address;
import com.BankingApplication.BankingApplication.dto.Bank;

@Repository
public class Addressdao
{
	@Autowired
	AddressRepo repo;
	
	public Address saveAddress(Address a)
	{
		return repo.save(a);
		
	}
	
	public Address findAddress(int id)
	{
		Optional<Address> address= repo.findById(id);
		return address.get();
	}
	
	public Address deleteAddress(int id)
	{
		Address exaddress =findAddress(id);
		if(exaddress!=null)
		{
			repo.delete(exaddress);
			return exaddress;
		}
		return null;
	}
	
	public List<Address> findAllAddress()
	{
		return repo.findAll();
	}
	
	public Address updateAddress(Address a,int id)
	{
		Address exaddress = findAddress(id);
		if(exaddress!=null)
		{
			if(a.getId()==0)
			{
				a.setId(exaddress.getId());
			}
			if(a.getStreet()==null)
			{
				a.setStreet(exaddress.getStreet());
			}
			if(a.getState()==null)
			{
				a.setState(exaddress.getState());;
			}
			if(a.getPincode()==0)
			{
				a.setPincode(exaddress.getPincode());;
			}
			if(a.getContact()==0)
			{
				a.setContact(exaddress.getContact());
			}
			if(a.getCity()==null)
			{
				a.setCity(exaddress.getCity());
			}
			
			return repo.save(a);
		}
		return null;
	}


}
