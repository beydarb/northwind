package com.example.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.northwind.entities.abstracts.IEntity;

import lombok.Data;


@Data
@Entity
@Table(name="card_details")
public class CardDetails implements IEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="card_id")
	private int cardId;
	@Column(name="product_id")
	private int productId;
	@Column(name="quantity")
	private int quantity;
	@Column(name="customer_id")
	private String customerId;
}
