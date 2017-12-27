package com.bjtu.item.entity;

import com.bjtu.item.utils.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class Order {

	private Long id;
	private Double price;
	private Map<Long, Integer> itemIdQty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Map<Long, Integer> getItemIdQty() {
		return itemIdQty;
	}

	public void setItemIdQty(Map<Long, Integer> itemIdQty) {
		this.itemIdQty = itemIdQty;
	}

	public void setJsonItemIdQty(String itemIdQty){
		this.itemIdQty = JsonUtil.fromJson(itemIdQty,new TypeToken<Map<Long, Integer>>() {
		}.getType());
	}

	public String getJsonItemIdQty(){
		return JsonUtil.toJson(itemIdQty);
	}

}