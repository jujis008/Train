
package com.bk.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> cartItems=new HashMap<>();
	
	private double total;


	public Map<String, CartItem> getCartItems() {
	
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
	
		this.cartItems = cartItems;
	}

	public double getTotal() {
	
		return total;
	}

	public void setTotal(double total) {
	
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [total=" + total + "]";
	}

	public Cart(Map<String, CartItem> cart, double total) {
		super();
		this.cartItems = cart;
		this.total = total;
	}

	public Cart() {
		
		super();
		//TODO 
			
	}
	

}

	