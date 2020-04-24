package com.jdc.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.jdc.model.entity.Shop;
import com.jdc.model.repo.ShopRepo;

@Service
public class ShopServiceImp implements ShopService {

	private final ShopRepo shoprepo;

	
    public ShopServiceImp(ShopRepo shoprepo) {
		super();
		this.shoprepo = shoprepo;
	}


	@Override
    public Shop createShop(Shop shop) {
		shop.setCreateDate(LocalDate.now());
		shop.setExpireDate(LocalDate.now().plusDays(60));
		shop.setShopLogoLocation("http://localhost/images/shoplogo.png");
		shop.setShopProfileLocation("http://localhost/images/shopprofile.png");
		shop.setShopLogoName("shoplogo.png");
		shop.setShopProfileName("shopprofile.png");
		shop.setEnable(true);
        return shoprepo.save(shop);
    }
}
