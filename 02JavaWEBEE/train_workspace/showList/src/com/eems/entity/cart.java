package com.eems.entity;

public class cart {
	private int id;
	private String name;
	private String price;
	private int num;
	private String count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public cart(int id, String name, String price, int num, String count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
		this.count = count;
	}

}
