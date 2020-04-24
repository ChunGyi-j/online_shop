package com.jdc.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String shopName;
	private Boolean enable;
	private LocalDate createDate;
	private LocalDate expireDate;
	private int shopRating;
	private String shopInfo;
	private String shopProfileName;
	private String shopLogoName;
	private String shopProfileLocation;
	private String shopLogoLocation;
	private String contact;
	@OneToMany
	private List<Item> item;
	@Embedded
	private Address address;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public int getShopRating() {
		return shopRating;
	}

	public void setShopRating(int shopRating) {
		this.shopRating = shopRating;
	}

	public String getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}

	public String getShopProfileName() {
		return shopProfileName;
	}

	public void setShopProfileName(String shopProfileName) {
		this.shopProfileName = shopProfileName;
	}

	public String getShopLogoName() {
		return shopLogoName;
	}

	public void setShopLogoName(String shopLogoName) {
		this.shopLogoName = shopLogoName;
	}

	
	public String getShopProfileLocation() {
		return shopProfileLocation;
	}

	public void setShopProfileLocation(String shopProfileLocation) {
		this.shopProfileLocation = shopProfileLocation;
	}

	public String getShopLogoLocation() {
		return shopLogoLocation;
	}

	public void setShopLogoLocation(String shopLogoLocation) {
		this.shopLogoLocation = shopLogoLocation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
}
