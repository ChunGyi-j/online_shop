package com.jdc.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.jdc.model.entity.Account;
import com.jdc.model.entity.Account.Role;
import com.jdc.model.entity.Item;
import com.jdc.model.entity.Shop;
import com.jdc.model.repo.AccountRepo;
import com.jdc.model.repo.ShopRepo;

@Service
public class ShopServiceImp implements ShopService {

	private final ShopRepo shopRepo;
	private final AccountRepo accountRepo;

	
    public ShopServiceImp(ShopRepo shopRepo,AccountRepo accountRepo) {
		super();
		this.shopRepo = shopRepo;
		this.accountRepo = accountRepo;
	}


	@Override
    public Shop createShop(Shop shop) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		Account a = accountRepo.findByEmail(username);
		a.setRole(Role.ROLE_SHOPKEEPER);
		accountRepo.save(a);
		
		shop.setAccount(a); 
		shop.setCreateDate(LocalDate.now());
		shop.setExpireDate(LocalDate.now().plusDays(60));
		shop.setShopLogoLocation("http://localhost/images/shoplogo.png");
		shop.setShopProfileLocation("http://localhost/images/shopprofile.png");
		shop.setShopLogoName("shoplogo.png");
		shop.setShopProfileName("shopprofile.png");
		shop.setEnable(true);
	
        return shopRepo.save(shop);
    }


	@Override
	public Shop findByAccount(String email) {
		Shop shop = shopRepo.findByAccountEmail(email);
		return shop;
	}


	
}
