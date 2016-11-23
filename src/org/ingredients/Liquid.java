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
		this.setName(bits[0]);
		this.setColor(bits[1]);
		this.setTemperature(bits[2]);
		double d = Double.parseDouble(bits[3]);
		this.setAmount(d);
		
	}

	@Override
	public boolean formatGood(String in) {
		// TODO Auto-generated method stub
		
		//expecting name,color,temperature,amount
		//4 commas
		
		int commas = in.length() - in.replace(",", "").length();
		if(commas == 4){
			return true;
		}
		else{
			return false;
		}
	}

}
