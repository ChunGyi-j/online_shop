package com.jdc.services;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.model.entity.Account;
import com.jdc.model.repo.AccountRepo;

@Service
public class AccountServiceImp implements AccountService{
	
	@Value("${nginx.location}")
	private String nginxLocation;

	@Value("${image.baseDir}")
	private String imageBaseDir;
	
	private final AccountRepo accountRepo;
	private final PasswordEncoder encoder;

	public AccountServiceImp(AccountRepo accountRepo, PasswordEncoder encoder) {
		super();
		this.accountRepo = accountRepo;
		this.encoder = encoder;
	}

	@Override
	public Account createAccount(Account account) {
		account.setProfilephotoLocation("http://localhost/images/profile.png");
		account.setProfilephotoName("profile.png");
		account.setEnable(true);
		System.out.println(account.getPassword());
        account.setPassword(encoder.encode(account.getPassword()));
        return accountRepo.save(account); 
	}

	@Override
	public Account loginAccount() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		return accountRepo.findByEmail(username);
	}

	@Override
	public Account editMemberProfilePhoto(MultipartFile photo,Account account) {
		
		String orginalName = photo.getOriginalFilename();
		String newName = LocalDateTime.now().toString().concat(orginalName);
		String replaceName = newName.replace(":", "-");
		String imagePath = nginxLocation.concat(replaceName);
		
		account.setProfilephotoLocation(imagePath);
		account.setProfilephotoName(replaceName);
		
		try {
			photo.transferTo(Paths.get(imageBaseDir).resolve(replaceName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return accountRepo.save(account);
		 
	}

	@Override
	public Account findById(Long id) {
		return accountRepo.getOne(id);
	}

	@Override
	public Account editMemberProfileName(Account account) {
		return accountRepo.save(account);
	}
	
	@Override
	public Boolean samePassword(Account account,String oldPassword){
		System.out.println(oldPassword);
		String password1= oldPassword;
		String password2=oldPassword;
		System.out.println(account.getPassword());
		System.out.println(encoder.encode(password1).toString()+" -password1");
		System.out.println(encoder.encode(password2).toString()+ "- password2");
		return account.getPassword().equals(encoder.encode(oldPassword));	
	}

	@Override
	public Account editMemberProfilePassword(Account account,String newPassword) {
		account.setPassword(encoder.encode(newPassword));
		return accountRepo.save(account);
	}
	

}
