package com.sjprogramming.bankapp.service;

import java.util.List;

import com.sjprogramming.bankapp.entity.Account;

public interface AccountService {
	 //create table 
	public Account createAccount(Account account);
	public Account getAccoununtDeteialsBYAccountNumber(Long accountNumber);
	public Account getAccountDetails(Long accountNumber,Double amount);
	public List<Account>getAllAccountDetailAccounts();
	// account don
	
	//diposite money
	public Account depositAmount(long accountNumber,Double amount);
	public Account withdrawAmount(long accountNumber,Double amount);

	public void CloseAccount(long accountNumber);
}
