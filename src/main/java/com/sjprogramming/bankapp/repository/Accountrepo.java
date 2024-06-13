package com.sjprogramming.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjprogramming.bankapp.entity.Account;
@Repository
public interface Accountrepo extends JpaRepository<Account,Long > {

}
