package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.OrderEntity;
import com.amazon.request.OrderRequest;
import com.amazon.service.OrderService;

@RestController
@RequestMapping("/amazon")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/placeorder")
	public String placeOrder( @RequestBody OrderRequest request)
	{
		System.out.println("OrderController.placeOrder():::::::::::::::");
		String response = orderService.placeOrder(request);
		
		return response ;
	}
	
	@GetMapping("/search")
	public List<OrderEntity> findByItemName(@RequestParam String itemName)
	{
		System.out.println("OrderController.searchOrder()");
		
		List<OrderEntity> orderList = orderService.findByItemName(itemName);
		return orderList;
	}
	
	@DeleteMapping("/deleteByName")
	public String deleteOrderByName(@RequestParam String itemName) {
	    System.out.println("OrderController.deleteOrderByName() called for: " + itemName);
	    return orderService.deleteByItemNameIgnoreCase(itemName);
	}

	
}
