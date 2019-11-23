package com.calculator.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class ItemInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Menu_seq")
    @SequenceGenerator(sequenceName = "Menu_seq",allocationSize = 1, name = "Menu_seq")
	private int itemId;
	private String item;
	private int price;
	private String qty;
	private String typeOfItem;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getTypeOfItem() {
		return typeOfItem;
	}

	public void setTypeOfItem(String typeOfItem) {
		this.typeOfItem = typeOfItem;
	}

}
