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
		//Name,Amount,Optional(Y,N)
		
		String[] bits = in.split(",");
		this.setName(bits[0]);
		double d = Double.parseDouble(bits[1]);
		this.setAmount(d);
		if(bits[2]== "Y"){
			this.setOptional(true);
		}
		else{
			this.setOptional(false);
		}
		
	}



	@Override
	public boolean formatGood(String in) {
		// TODO Auto-generated method stub
		// we expect to see Name,Amount,Optional(Y,N)
		
		int commas = in.length() - in.replace(",", "").length();
		if(commas == 2){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	

}
