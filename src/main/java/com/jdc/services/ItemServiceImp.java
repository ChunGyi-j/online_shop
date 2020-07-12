package com.jdc.services;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.model.entity.Account;
import com.jdc.model.entity.Item;
import com.jdc.model.repo.AccountRepo;
import com.jdc.model.repo.ItemRepo;

@Service
public class ItemServiceImp implements ItemService {

	@Value("${nginx.location}")
	private String nginxLocation;

	@Value("${image.baseDir}")
	private String imageBaseDir;

	private final ItemRepo itemRepo;
	private final AccountRepo accountRepo;

	
	public ItemServiceImp(ItemRepo itemRepo, AccountRepo accountRepo) {
		super();
		
		this.itemRepo = itemRepo;
		this.accountRepo = accountRepo;
	}

	@Override
	public Item addItem(Item item) {
		return itemRepo.save(item);
	}

	@Override
	public Item save(MultipartFile files, Item item) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		Account a = accountRepo.findByEmail(username);

		String orginalName = files.getOriginalFilename();
		String newName = LocalDateTime.now().toString().concat(orginalName);
		String replaceName = newName.replace(":", "-");
		String imagePath = nginxLocation.concat(replaceName);


		item.setItemRating(0);
		item.setAccount(a);
		item.setSellDate(LocalDateTime.now());
		item.setItemPhotoLocation(imagePath);
		item.setItemPhotoName(replaceName);
		try {
			files.transferTo(Paths.get(imageBaseDir).resolve(replaceName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return itemRepo.save(item);

	}

	@Override
	public List<Item> findTopItem() {
		return itemRepo.findAll();
	}

	@Override
	public List<Item> findByAccountId(Long id) {
		return	itemRepo.findByAccountId(id);
		
	}

	@Override
	public Item findByItemId(Long id) {
		return itemRepo.getOne(id);
	}

	

}
