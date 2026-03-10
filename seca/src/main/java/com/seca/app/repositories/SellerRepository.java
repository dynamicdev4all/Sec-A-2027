package com.seca.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.seca.app.models.Item;
import com.seca.app.models.Seller;

@Repository
public class SellerRepository {
	
	public Map<Long,ArrayList<Item>> items = new HashMap<Long, ArrayList<Item>>();
	
	public Map<Long,Seller> seller = new HashMap<Long, Seller>();
	
	
	public String createItem(long sellerId, String itemName, double price, String desc, String ratings, String sellerName) {
		Item firstItem = new Item(itemName, price, desc, ratings, sellerName, sellerId);
		
		if(items.containsKey(sellerId)) {
			Item newItem = new Item(itemName, price, desc, ratings, sellerName, sellerId);
			items.get(sellerId).add(newItem);
			return "Item Added";
		}else {
			ArrayList<Item> itemList = new ArrayList<Item>();
			itemList.add(firstItem);
			items.put(sellerId, itemList);
			return "First Item Added.";
		}	
	}
	
	public ArrayList<Item> showItems(long sellerID) {
		return items.get(sellerID);
	}
}
