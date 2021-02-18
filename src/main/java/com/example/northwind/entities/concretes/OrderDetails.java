package com.example.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.example.northwind.CompositeKey;
import com.example.northwind.entities.abstracts.IEntity;

import lombok.Data;

@Data
@Entity
@IdClass(CompositeKey.class)
@Table(name="order_details")
@Component 
public class OrderDetails implements IEntity{
	@Id
	@Column(name="order_id")
	private int orderId;
	@Id
	@Column(name="product_id")
	private int productId;
	@Column(name="quantity")
	private int quantity;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="discount")
	private double discount;
}
