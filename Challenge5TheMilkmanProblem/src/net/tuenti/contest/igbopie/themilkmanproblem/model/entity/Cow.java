package net.tuenti.contest.igbopie.themilkmanproblem.model.entity;

public class Cow {

	private int weight;
	private int production;
	private int coeficient;
	public Cow(int weight, int production) {
		super();
		this.weight = weight;
		this.production = production;
		this.coeficient=production/weight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getProduction() {
		return production;
	}
	public void setProduction(int production) {
		this.production = production;
	}
	public int getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(int coeficient) {
		this.coeficient = coeficient;
	}
}
