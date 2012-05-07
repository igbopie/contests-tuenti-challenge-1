package net.tuenti.contest.igbopie.thebusstations.model.entity;

public class Travel implements Comparable<Travel>{
	private String origin;
	private String destination;
	private int maxBuses;
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getMaxBuses() {
		return maxBuses;
	}
	public void setMaxBuses(int timeCost) {
		this.maxBuses = timeCost;
	}
	
	public String toString(){
		return origin+","+destination+","+maxBuses;
	}
	@Override
	public int compareTo(Travel arg0) {
		return this.maxBuses-arg0.getMaxBuses();
	}
}
