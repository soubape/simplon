package com.sous.health.pharmacie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sous.health.pharmacie.entities.Order;
import com.sous.health.pharmacie.repository.OrderRepository;

@Service
public class OrderServiceImpl implements PharmacieServices<Order>{

	@Autowired
	private OrderRepository orderRepository;
	
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order getById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void update(Order order, Long id) {
		Order order1 = orderRepository.findById(id).get();
		order1.setPk(order.getPk());
		order1.setBeginDate(order.getBeginDate());
		order1.setEndDate(order.getEndDate());
		order1.setStatus(order.getStatus());
		
	}

	@Override
	public void delete(Long id) {
		return;
		
	}

	@Override
	public List<Order> findByNameOrPartName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
