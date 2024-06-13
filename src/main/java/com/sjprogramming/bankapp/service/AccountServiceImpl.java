package com.sjprogramming.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.bankapp.entity.Account;
import com.sjprogramming.bankapp.repository.Accountrepo;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	Accountrepo repo;
	
	@Override
	public Account createAccount(Account account) {
	//account save
		Account account_saved=repo.save(account);
		return account_saved;
	}
	@Override
	public Account getAccoununtDeteialsBYAccountNumber(Long accountNumber) {
	Optional<Account>account=repo.findById(accountNumber);
	//check account is present in database runtime exception
	if(account.isEmpty()) {
		throw new RuntimeException("Account is not present");
	}
	//Account is not empty we take account.get();
	Account account_found=account.get();
		return account_found;
	}
	
//all accounts details
	@Override
	public List<Account> getAllAccountDetailAccounts() {
		List<Account>ListOFAccounts=repo.findAll();
		
		return ListOFAccounts;
	}
	
	
	@Override
	public Account getAccountDetails(Long accountNumber, Double amount) {
		return null;
	}

	

	@Override
	public Account depositAmount(long accountNumber, Double amount) {
	    Optional<Account> account = repo.findById(accountNumber);
	    if (account.isEmpty()) {
	        throw new RuntimeException("Account is not present");
	    }
	    Account accountPresent = account.get();
	    Double totalBalance = accountPresent.getAccount_balance() + amount;
	    accountPresent.setAccount_balance(totalBalance);
	    repo.save(accountPresent);
	    
	    return accountPresent;
	}
	//withdraw amount
	
	@Override
	public Account withdrawAmount(long accountNumber, Double amount) {
	    Optional<Account> account = repo.findById(accountNumber);
	    if (account.isEmpty()) {
	        throw new RuntimeException("Account is not present");
	    }
	    Account accountPresent = account.get();
	double accountBalance= accountPresent.getAccount_balance()-amount;
	   accountPresent.setAccount_balance(accountBalance);
	   repo.save(accountPresent);
	return accountPresent;
	}

	//close Account
	@Override
	public void CloseAccount(long accountNumber) {
		getAccoununtDeteialsBYAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
	}
	

}