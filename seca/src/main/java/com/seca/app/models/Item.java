package com.seca.app.models;

public class Item {
	public Item(String name, double price, String desc, String ratings, String sellerName, long sellerID) {
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.ratings = ratings;
		this.sellerName = sellerName;
		this.sellerID = sellerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public long getSellerID() {
		return sellerID;
	}
	public void setSellerID(long sellerID) {
		this.sellerID = sellerID;
	}
	String name;
	double price;
	String desc;
	String ratings;
	String sellerName;
	long sellerID;
}
