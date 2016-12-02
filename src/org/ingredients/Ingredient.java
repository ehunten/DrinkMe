package org.ingredients;

public abstract class Ingredient {

	private String name;
	private String color;
	//private Double amount;
	private String amount;
	
	public Ingredient() {
		this.name = "";
		this.amount = "";
	}
	
	public Ingredient(String name, String amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
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
	public String getAmount(){
		return amount;
	}

	
	public abstract String print();
	
	public abstract void parse(String in);
	
	public abstract boolean formatGood(String in);
	
}
