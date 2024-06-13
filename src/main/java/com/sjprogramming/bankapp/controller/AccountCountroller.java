package com.sjprogramming.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogramming.bankapp.entity.Account;
import com.sjprogramming.bankapp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountCountroller {
	
@Autowired
private AccountService service;
	//create account
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		//logic create account
	Account createAccount=service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	// Get account details by account number//pass just account id get account detais
	@GetMapping("/{accountNumber}")
	 public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
	Account account =service.getAccoununtDeteialsBYAccountNumber(accountNumber);
	 return account;
	 }
	//get all account
	@GetMapping("/getallaccount")
	public List<Account>getAllAccountDetails(){
		List<Account>allAccountDetails=service.getAllAccountDetailAccounts();
		return allAccountDetails;
	}
	// deposit money//update using put mapping
	@PutMapping("/deposit/{accountNumber}/{amount}")//@pathvarable use old data  data change purpose
	public Account depositAccount(@PathVariable long accountNumber,@PathVariable Double amount) {
		Account account=service.depositAmount(accountNumber,amount );
		return account;
	}
	//with draw amount
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withdrawAccount(@PathVariable long accountNumber,@PathVariable Double amount) {
		Account account=service.withdrawAmount(accountNumber,amount );
		return account;
}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable long accountNumber) {
		
		service.CloseAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account close");
	}
}









