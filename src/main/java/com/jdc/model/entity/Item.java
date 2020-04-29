package com.jdc.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int instock;
	private int price;
	private int itemRating;
	private LocalDateTime sellDate;
	private String itemPhotoName;
	private String itemPhotoLocation;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Account account;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInstock() {
		return instock;
	}
	public void setInstock(int instock) {
		this.instock = instock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getItemRating() {
		return itemRating;
	}
	public void setItemRating(int itemRating) {
		this.itemRating = itemRating;
	}
	public LocalDateTime getSellDate() {
		return sellDate;
	}
	public void setSellDate(LocalDateTime sellDate) {
		this.sellDate = sellDate;
	}
	public String getItemPhotoName() {
		return itemPhotoName;
	}
	public void setItemPhotoName(String itemPhotoName) {
		this.itemPhotoName = itemPhotoName;
	}
	public String getItemPhotoLocation() {
		return itemPhotoLocation;
	}
	public void setItemPhotoLocation(String itemPhotoLocation) {
		this.itemPhotoLocation = itemPhotoLocation;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
	
	

}
