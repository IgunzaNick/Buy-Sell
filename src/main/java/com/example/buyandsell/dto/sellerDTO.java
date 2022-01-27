package com.example.buyandsell.dto;

import com.example.buyandsell.model.Category;

import lombok.Data;

@Data
public class sellerDTO {
	private int id;
	private String name;
	private int price;
	private int phonenumber;
	private Category category;
	private String AccountDescription;
	private String link;
	private String imagename;
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
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	

}
