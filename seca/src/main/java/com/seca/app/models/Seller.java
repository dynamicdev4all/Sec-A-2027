package com.seca.app.models;

import java.util.ArrayList;

public class Seller {
	public Seller(String name, String GST, long id, String address, ArrayList<Item> items) {
		this.name = name;
		this.GST = GST;
		this.id = id;
		this.address = address;
		this.items = items;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGST() {
		return GST;
	}
	public void setGST(String gST) {
		GST = gST;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	String name;
	String GST;
	long id;
	String address;
	ArrayList<Item> items;
}
