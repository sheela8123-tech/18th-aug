package com.amazon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.entity.OrderEntity;
import com.amazon.repository.OrderRepository;
import com.amazon.request.OrderRequest;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public String placeOrder(OrderRequest request)
	{
		
		OrderEntity entity = new OrderEntity();
		
		System.out.println("OrderService.placeOrder()");
		
	    entity.setDescription(request.getDescription());
		entity.setItemName(request.getItemName());
		entity.setPrice(request.getPrice());
		entity.setQty(request.getQty());
		
		entity = orderRepository.save(entity);
		
		int orderId  = entity.getId();
		if(orderId > 0)
		{
			return "Order has been placed successfully ..." + orderId;
		}
		
		
		return "unable to process your order ";
	}
	
	
	public List<OrderEntity> findByItemName(String itemName)
	{
		System.out.println("OrderService.findByItemName()");
		List<OrderEntity> orderList = (List<OrderEntity>) orderRepository.findByItemNameContainingIgnoreCase(itemName);
		return orderList;
	}

    //@Transactional	
	public String deleteByItemNameIgnoreCase(String itemName) {
	    long deletedCount = orderRepository.deleteByItemNameIgnoreCase(itemName);

	    if (deletedCount > 0) {
	        return deletedCount + " order(s) deleted with item name: " + itemName;
	    } else {
	        return "No orders found with item name: " + itemName;
	    }
	}

}
