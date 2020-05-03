package com.jdc.model.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private Boolean enable;
	@Enumerated(EnumType.STRING)
	private Role role;
	private String profilephotoName;
	private String profilephotoLocation;
	@Embedded
	private Address address;


	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getProfilephotoName() {
		return profilephotoName;
	}

	public void setProfilephotoName(String profilephotoName) {
		this.profilephotoName = profilephotoName;
	}

	public String getProfilephotoLocation() {
		return profilephotoLocation;
	}

	public void setProfilephotoLocation(String profilephotoLocation) {
		this.profilephotoLocation = profilephotoLocation;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public enum Role {
		ROLE_ADMIN {
			@Override
			public String toString() {
				return "Admin";
			}
		},
		ROLE_SHOPKEEPER {
			@Override
			public String toString() {
				return "Shopkeeper";
			}
		},
		ROLE_MEMBER {
			@Override
			public String toString() {
				return "Member";
			}
		};
	}

	public Account() {
		this.role = Role.ROLE_MEMBER;
	}

}
