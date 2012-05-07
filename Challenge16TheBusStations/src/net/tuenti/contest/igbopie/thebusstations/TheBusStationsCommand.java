package net.tuenti.contest.igbopie.thebusstations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Stack;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.thebusstations.model.entity.State;
import net.tuenti.contest.igbopie.thebusstations.model.entity.Travel;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TheBusStationsCommand implements Command{
	private int nStations;
	private String origin;
	private String destination;

	private HashMap<String,ArrayList<Travel>> destravels;
	private HashMap<String,ArrayList<Travel>> travels;
	public static int MAX_TIME=-1;

	public TheBusStationsCommand(String line){

		destravels=new HashMap<String, ArrayList<Travel>>();
		travels=new HashMap<String, ArrayList<Travel>>();
		String[]tokens=line.split(" ");
		int i=0;
		for(String token:tokens){
			if(token!=null&&!token.equalsIgnoreCase("")){
				switch(i){
				case 0:
					this.nStations=Integer.parseInt(token);
					break;
				case 1:
					this.origin=token;
					break;
				case 2:
					this.destination=token;
					break;
				default:
					String[]travelToken=token.split(",");
					Travel travel=new Travel();
					travel.setOrigin(travelToken[0]);
					travel.setDestination(travelToken[1]);
					travel.setMaxBuses(Integer.parseInt(travelToken[2]));
					this.addTravel(travel);
				}

				i++;
			}
		}

	}

	private void addTravel(Travel travel){
		if(!travel.getOrigin().equalsIgnoreCase(this.destination)&&
				!travel.getDestination().equalsIgnoreCase(this.origin)&&travel.getMaxBuses()>0	){
			//No sense in keeping travels from destination or to origin
			ArrayList<Travel>ptravels=travels.get(travel.getOrigin());
			ArrayList<Travel>atravels=destravels.get(travel.getDestination());
			if(atravels==null){
				atravels=new ArrayList<Travel>();
				destravels.put(travel.getDestination(),atravels);
			}
			if(!atravels.contains(travel)){
				atravels.add(travel);
			}
			if(ptravels==null){
				ptravels=new ArrayList<Travel>();
				travels.put(travel.getOrigin(),ptravels);
			}
			
			if(!ptravels.contains(travel)){
				ptravels.add(travel);
			}
		}
	}

	@Override
	public String execute() {
		try{
			Long startTime=Calendar.getInstance().getTime().getTime();
			Stack<State>states=new Stack<State>();
			Stack<Travel>routes=new Stack<Travel>();
			boolean finished=false;

			State actualState=new State();
			actualState.setActualStation(origin);
			int maxbuses=0;
			int depth=0;
			while(!finished){
				Travel travel=this.nextTravel(actualState);
				//System.out.println(actualState+" "+maxbuses+" "+depth);
				if(travel!=null){
					depth++;
					states.push(actualState.clone());
					useTravel(travel, actualState);
					routes.push(travel);
				}else{
					Long checkTime=Calendar.getInstance().getTime().getTime();
					if(MAX_TIME>0&&checkTime-startTime>MAX_TIME){
						//TIME'S UP!
						finished=true;
					}else{
						depth--;
						//save maxsolution
						int maxbusesState=actualState.getMaxBuses();
						if(maxbusesState>maxbuses){
							maxbuses=maxbusesState;
						}
						if(!states.empty()){
							//Backtrack
							travel=routes.pop();
							actualState=states.pop();
							//We look for another posibility
							actualState.getDoNotUseTravels().add(travel);
							//return travel to the array
							addTravel(travel);
						}else{
							finished=true;
						}
					}

				}
			}
			//save maxsolution
			int maxbusesState=actualState.getMaxBuses();
			maxbuses=maxbuses<maxbusesState?maxbusesState:maxbuses;

			return maxbuses+"";

		}catch(Exception e){
			return "E:"+e;
		}
	}
	private Travel nextTravel(State actualState){
		ArrayList<Travel>atravels=travels.get(actualState.getActualStation());
		ArrayList<Travel>retravels=new ArrayList<Travel>();
		Travel travel=null;
		int maxTravel=0;
		if(atravels!=null){
			for(Travel t:atravels){
				if(actualState.getVisitedCities().contains(t.getDestination())){
					retravels.add(t);
				}else if(!actualState.getDoNotUseTravels().contains(t)&&!actualState.getVisitedCities().contains(t.getDestination())){
					//Some heuristics...
					if(travel==null||t.getMaxBuses()>maxTravel){
						travel=t;
						maxTravel=t.getMaxBuses();
					}
					if(t.getDestination().equalsIgnoreCase(this.destination)){
						travel=t;
						break;
					}
				}
			}
		}
		atravels.removeAll(retravels);
		if(travel!=null){
			atravels.remove(travel);
		}
		return travel;
	}
	private void useTravel(Travel travel,State actualState){
		if(actualState.getMaxBusesPath()==null||actualState.getMaxBusesPath()>travel.getMaxBuses()){
			actualState.setMaxBusesPath(travel.getMaxBuses());
		}
		actualState.setActualStation(travel.getDestination());
		actualState.getVisitedCities().add(travel.getDestination());

		if(actualState.getActualStation().equalsIgnoreCase(destination)){
			//We reach destination
			actualState.setActualStation(origin);
			actualState.setMaxBuses(actualState.getMaxBuses()+actualState.getMaxBusesPath());
			actualState.setMaxBusesPath(null);
			actualState.setVisitedCities(new ArrayList<String>());

		}
	}

}
