package com.jdc.services;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.model.entity.Item;
import com.jdc.model.repo.ItemRepo;
@Service
public class ItemServiceImp implements ItemService{
	
	@Value("${nginx.location}")
    private String nginxLocation;

    @Value("${image.baseDir}")
    private String imageBaseDir;

	private final ItemRepo itemRepo;
	
	public ItemServiceImp(ItemRepo itemRepo) {
		super();
		this.itemRepo = itemRepo;
	}

	@Override
	public Item addItem(Item item) {
		return itemRepo.save(item);
	}
	@Override
    public Item save ( MultipartFile files ,Item item) {
        
        String orginalName = files.getOriginalFilename();
        String newName = LocalDateTime.now().toString().concat(orginalName);
        String replaceName = newName.replace(":", "-");
        String imagePath = nginxLocation.concat(replaceName);

        Item i = new Item();
        i.setInstock(item.getInstock());
        i.setPrice(item.getPrice());
        i.setSellDate(LocalDateTime.now());
        i.setId(item.getId());
        i.setItemPhotoName(replaceName);
        i.setItemPhotoLocation(imagePath);
        i.setName(item.getName());
        try {
            files.transferTo(Paths.get(imageBaseDir).resolve(replaceName));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
       return itemRepo.save(i);
        
    }

	@Override
	public List<Item> findTopItem() {
		return itemRepo.findAll();
	}

	
}
