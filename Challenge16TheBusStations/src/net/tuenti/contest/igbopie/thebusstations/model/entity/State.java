package net.tuenti.contest.igbopie.thebusstations.model.entity;

import java.util.ArrayList;
import java.util.List;

public class State {
	private Integer maxBuses=0;
	private Integer maxBusesPath=null;
	private String actualStation;
	private List<Travel>doNotUseTravels=new ArrayList<Travel>();
	
	private List<String>visitedCities=new ArrayList<String>();
	
	

	
	public State clone(){
		State state=new State();
		state.maxBuses=new Integer(maxBuses);
		if(maxBusesPath!=null){
			state.maxBusesPath=new Integer(maxBusesPath);
		}
		state.actualStation=new String(actualStation);
		state.doNotUseTravels=new ArrayList<Travel>(doNotUseTravels);
		state.visitedCities=new ArrayList<String>(visitedCities);
		return state;
	}
	
	public List<String> getVisitedCities() {
		return visitedCities;
	}

	public void setVisitedCities(List<String> visitedCities) {
		this.visitedCities = visitedCities;
	}

	
	public Integer getMaxBuses() {
		return maxBuses;
	}
	public void setMaxBuses(Integer maxBuses) {
		this.maxBuses = maxBuses;
	}
	public Integer getMaxBusesPath() {
		return maxBusesPath;
	}
	public void setMaxBusesPath(Integer maxBusesPath) {
		this.maxBusesPath = maxBusesPath;
	}
	public String getActualStation() {
		return actualStation;
	}
	public void setActualStation(String actualStation) {
		this.actualStation = actualStation;
	}

	public List<Travel> getDoNotUseTravels() {
		return doNotUseTravels;
	}

	public void setDoNotUseTravels(List<Travel> doNotUseTravels) {
		this.doNotUseTravels = doNotUseTravels;
	}
	

	public String toString(){
		return actualStation+","+maxBuses+","+maxBusesPath;
	}
}
