package org.ingredients;

public class Glass {

	private String shape;
	private double volume;
	
	public Glass() {
		shape = "";
		volume = 0;
	}
	public Glass(String shape) {
		this.shape = shape;
	}
	
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	
}
