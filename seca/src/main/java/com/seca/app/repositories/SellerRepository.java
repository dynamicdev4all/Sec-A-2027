package com.seca.app.repositories;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.seca.app.models.Item;

public class SellerRepository {
	
	Map<Long,ArrayList<Item>> items = new HashMap<Long, ArrayList<Item>>();
	
	
	public void createItem(long sellerId, String itemName, double price, String desc, String ratings, String sellerName) {
	
		
		Item firstItem = new Item(itemName, price, desc, ratings, sellerName, sellerId);
		
		
		
		
		if(items.containsKey(sellerId)) {
			Item newItem = new Item(itemName, price, desc, ratings, sellerName, sellerId);
			items.get(sellerId).add(newItem);
		}else {
			ArrayList<Item> itemList = new ArrayList<Item>();
			itemList.add(firstItem);
			items.put(sellerId, itemList);
		}
		
	}
}
