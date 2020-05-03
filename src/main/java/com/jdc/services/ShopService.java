package com.jdc.services;

import java.util.List;

import com.jdc.model.entity.Item;
import com.jdc.model.entity.Shop;

public interface ShopService {

    Shop createShop(Shop shop);
    Shop findByAccount(String email);
   
    

}
