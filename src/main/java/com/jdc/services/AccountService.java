package com.jdc.services;

import org.springframework.web.multipart.MultipartFile;

import com.jdc.model.entity.Account;

public interface AccountService {
	
	Account createAccount(Account account);
	Account findById(Long id);
	Account loginAccount();
	Account editMemberProfilePhoto(MultipartFile photo,Account account);
	Account editMemberProfileName(Account account);
	Account editMemberProfilePassword(Account account,String newPassword);
    Boolean samePassword(Account account,String oldPassword);

}
