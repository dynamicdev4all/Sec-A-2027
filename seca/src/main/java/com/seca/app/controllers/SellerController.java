package com.seca.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seca.app.models.Item;
import com.seca.app.repositories.SellerRepository;


@RestController
public class SellerController {
	
	
	@Autowired
	SellerRepository repo;
	
	@PostMapping("/seller/create_new")
	public String createItem(@RequestBody Item newItem) {
		return repo.createItem(
				newItem.getSellerID(), 
				newItem.getName(), 
				newItem.getPrice(), 
				newItem.getDesc(), 
				newItem.getRatings(), 
				newItem.getSellerName()
						);
	}
	
	
	@GetMapping("/seller/show_all_items/{id}")
	public ArrayList<Item> showItems(@PathVariable long id) {
		return repo.showItems(id);
	}
}
