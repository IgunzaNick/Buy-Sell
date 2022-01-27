package com.example.buyandsell.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class SellerProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int price;
	private int phonenumber;
	private Category category;
	private String AccountDescription;
	private String link;
	private String email;
	private String password;
	private String imagename;
	public SellerProduct(int id, String name, int price, int phonenumber, Category category, String accountDescription,
			String link, String email, String password, String imagename) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.phonenumber = phonenumber;
		this.category = category;
	               AccountDescription = accountDescription;
		this.link = link;
		this.email = email;
		this.password = password;
		this.imagename = imagename;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getAccountDescription() {
		return AccountDescription;
	}
	public void setAccountDescription(String accountDescription) {
		AccountDescription = accountDescription;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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

	public SellerProduct() {
		super();
		
	}
	
	

}
