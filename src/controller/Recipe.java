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
	
	
	
}
