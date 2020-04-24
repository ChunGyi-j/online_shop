package com.jdc.services;

import org.springframework.stereotype.Service;

import com.jdc.model.entity.Account;
import com.jdc.model.repo.AccountRepo;
@Service
public class AccountServiceImp implements AccountService{
	
	private final AccountRepo accountrepo;

	public AccountServiceImp(AccountRepo accountrepo) {
		super();
		this.accountrepo = accountrepo;
	}

	@Override
	public Account createAccount(Account account) {
		account.setProfilephotoLocation("http://localhost/images/profile.png");
		account.setProfilephotoName("profile.png");
		account.setEnable(true);
		accountrepo.save(account);
		return null;
	}

}
