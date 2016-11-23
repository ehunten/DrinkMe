package org.ingredients;

public abstract class Ingredient {

	private String name;
	private String color;
	private double amount;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public abstract String print();
	
	public abstract void parse(String in);
	
	public abstract boolean formatGood(String in);
	
}
