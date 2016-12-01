package controller;

import java.util.ArrayList;

import org.ingredients.*;

public class Recipe {

	private String name;
	private ArrayList<Liquid> liquids;
	private ArrayList<Solid> solids;
	private String[] directions;
	private String hangoverPotential;
	private Glass glass;
	
	public Recipe(){
		name = "";
		liquids = new ArrayList<Liquid>();
		solids = new ArrayList<Solid>();
		directions = new String[225];
		hangoverPotential = "you dead";
		glass = new Glass();
	}
	
	
	public void setDirections(String[] directions) {
		this.directions = directions;
	}
	public String[] getDirections(){
		return directions;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Liquid> getLiquids() {
		return liquids;
	}
	public void setLiquids(ArrayList<Liquid> liquids) {
		this.liquids = liquids;
	}
	public ArrayList<Solid> getSolids() {
		return solids;
	}
	public void setSolids(ArrayList<Solid> solids) {
		this.solids = solids;
	}

	public String getHangoverPotential() {
		return hangoverPotential;
	}
	public void setHangoverPotential(String hangoverPotential) {
		this.hangoverPotential = hangoverPotential;
	}
	public Glass getGlass() {
		return glass;
	}
	public void setGlass(Glass glass) {
		this.glass = glass;
	}
	
	public String[] giveStrings(){
		String[] output = {"","","","","","",""};
		//recpie object to seperate strings
		//name string, alc string (amount name, amount name)
		//mixer string, solids string, glass STring, directions string
		output[0] = this.getName();
		for(int i=0; i<this.getLiquids().size(); ++i){
			if(this.getLiquids().get(i).isAlcohol() == true){
				output[1] = output[1] + this.getLiquids().get(i).getAmount().toString() + " " 
						+ this.getLiquids().get(i).getName() + ",";
			}
			else{
				output[2] = output[2] + this.getLiquids().get(i).getAmount().toString() + " " 
						+ this.getLiquids().get(i).getName() + ",";
			}
		}
		for(int i=0; i<this.getSolids().size(); ++i){
			output[3] = output[3] + this.getSolids().get(i).getAmount().toString() + " "
					+ this.getSolids().get(i).getName() + ",";
		}
		output[4] = this.getGlass().getShape();
		String directString = "";
		String[] temp = this.getDirections();
		for(int i=0; i<this.getDirections().length; ++i){
			directString = directString + temp[i] + ", ";
		}
		directString = directString.replaceAll("[\\n\\r]", "");
		output[5] = directString;
		output[6] = this.getHangoverPotential();
		return output;
	}
	
	
}
