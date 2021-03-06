package com.jdc.services;

import com.jdc.model.entity.Account;
import com.jdc.model.entity.Shop;
import org.springframework.stereotype.Component;

@Component
public interface ShopService {

    Shop createShop(Shop shop);
    Shop findByAccount(String email);
    Shop findByAccount(Account account);
   
    

}
