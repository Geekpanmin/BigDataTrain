package com.eems.entity;

public class EquipmentType {
	private int id;
	private String type;//设备类型
	public EquipmentType() {
	}
	public EquipmentType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
