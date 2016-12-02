package controller;

import java.util.ArrayList;

import org.ingredients.*;

public class Recipe {

	private String name;
	private ArrayList<Liquid> liquids;
	private ArrayList<Solid> solids;
	private String[] directions;
	private String hangoverPotential;
	private String dirString;
	private String gl;
	private Glass glass;
	private String hp;
	
	public Recipe(){
		name = "";
		liquids = new ArrayList<Liquid>();
		solids = new ArrayList<Solid>();
		directions = new String[225];
		hangoverPotential = "you dead";
		glass = new Glass();
	}
	
	public Recipe(String name, String alc, String mix, String sol, String gl, String dirString, String hp) {
		this.name = name;
		this.dirString = dirString;
		this.gl = gl;
		
		this.glass = new Glass(gl);
		String l[] = alc.split(", ");
		for (int i = 0; i<l.length; i++) {
			String sp[] = l[i].split(" ");
			this.liquids.add(new Liquid(sp[0], sp[1], true));
		}

		String m[] = mix.split(", ");
		for (int i = 0; i<l.length; i++) {
			String sp[] = l[i].split(" ");
			this.liquids.add(new Liquid(sp[0], sp[1], false));
		}
		
		String s[] = sol.split(", ");
		for (int i = 0; i<s.length; i++) {
			String sp[] = s[i].split(" ");
			this.solids.add(new Solid(sp[0], sp[1], false));
		}
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
