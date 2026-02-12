package com.amazon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amazon.entity.OrderEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

	Iterable<OrderEntity> findByItemNameContainingIgnoreCase(String itemName);
	
	long deleteByItemNameIgnoreCase(String itemName);

}
