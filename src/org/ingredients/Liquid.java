package org.ingredients;

public class Liquid extends Ingredient{

	private String temperature;
	private boolean isAlcohol;
	
	
	
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public boolean isAlcohol() {
		return isAlcohol;
	}

	public void setAlcohol(boolean isAlcohol) {
		this.isAlcohol = isAlcohol;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void parse(String in) {
		// TODO Auto-generated method stub
		//will parse input and set all elements except is alc
		
		String[] bits = in.split(",");
		this.setName(bits[1]);
		double d = Double.parseDouble(bits[0]);
		this.setAmount(d);
		
	}

	@Override
	public boolean formatGood(String in) {
		// TODO Auto-generated method stub
		
		//expecting amount,name
		//1 commas
		
		int commas = in.length() - in.replace(",", "").length();
		if(commas == 1){
			return true;
		}
		else{
			return false;
		}
	}

}
