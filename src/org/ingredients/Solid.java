package org.ingredients;

public class Solid extends Ingredient {

	private boolean optional;
	
	
	
	public boolean isOptional() {
		return optional;
	}



	public void setOptional(boolean optional) {
		this.optional = optional;
	}



	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void parse(String in) {
		// TODO Auto-generated method stub
		//will parse out the expected format
		//amount,name
		
		String[] bits = in.split(",");
		this.setName(bits[1]);
		double d = Double.parseDouble(bits[0]);
		this.setAmount(d);

		
	}



	@Override
	public boolean formatGood(String in) {
		// TODO Auto-generated method stub
		// we expect to see amount,name
		
		int commas = in.length() - in.replace(",", "").length();
		if(commas == 1){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	

}
