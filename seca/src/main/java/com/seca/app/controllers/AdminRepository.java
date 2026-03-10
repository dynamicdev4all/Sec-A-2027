package com.seca.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.seca.app.models.Item;
import com.seca.app.models.Seller;
import com.seca.app.repositories.SellerRepository;

public class AdminRepository {
	
	@Autowired
	SellerRepository repo;
	public String updateItem(long sellerId, int itemIndex) {
		try {
			ArrayList<Item> itemList = repo.items.get(sellerId);
			
			Item updateItem = itemList.get(0);
			
			updateItem.setName("HP | Laptop i5 12Gen");
			
			return "Item updated Successfully.";
		} catch (Exception e) {
			return "Item update failed.";
		}
		
	}
	
	
	
	public void manageAccess(long sellerId) {
		Seller seller = repo.seller.get(sellerId);
		
		if(seller.isBanned() == false) {
			seller.setBanned(true);
			return;
		}
		seller.setBanned(false);
	}
}
