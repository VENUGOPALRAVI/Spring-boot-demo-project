package com.BankingApplication.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApplication.BankingApplication.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>
{

}
