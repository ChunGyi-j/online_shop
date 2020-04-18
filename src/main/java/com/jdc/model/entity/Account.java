package com.jdc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private Boolean enable;
	private Role role;
	
	 public enum Role {
	        ROLE_ADMIN {
	            @Override
	            public String toString() {
	                return "Admin";
	            }
	        }, ROLE_MEMBER {
	            @Override
	            public String toString() {
	                return "Member";
	            }
	        };
	    }

	    public  Account(){
	        this.role= Role.ROLE_MEMBER;
	    }
	}



