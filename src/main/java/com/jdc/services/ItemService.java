package com.jdc.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jdc.model.entity.Item;

public interface ItemService {
	Item addItem(Item item);
    Item save ( MultipartFile files ,Item item);
    List<Item> findTopItem();
    List<Item> findProfileProdcuts(Long id);

}
