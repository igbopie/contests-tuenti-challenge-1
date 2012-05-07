package net.tuenti.contest.igbopie.thestargateproblem;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.thestargateproblem.model.entity.Travel;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TheStargateCommand implements Command{
	private int nPlanets;
	private int origin;
	private int destination;
	private HashMap<Integer,List<Travel>> travels;

	public TheStargateCommand(String line){

		travels=new HashMap<Integer, List<Travel>>();
		String[]tokens=line.split(" ");
		int i=0;
		for(String token:tokens){
			if(token!=null&&!token.equalsIgnoreCase("")){
				switch(i){
				case 0:
					this.nPlanets=Integer.parseInt(token);
					break;
				case 1:
					this.origin=Integer.parseInt(token);
					break;
				case 2:
					this.destination=Integer.parseInt(token);
					break;
				default:
					String[]travelToken=token.split(",");
					Travel travel=new Travel();
					travel.setOrigin(Integer.parseInt(travelToken[0]));
					travel.setDestination(Integer.parseInt(travelToken[1]));
					travel.setTimeCost(Integer.parseInt(travelToken[2]));
					List<Travel>ptravels=travels.get(travel.getOrigin());
					if(ptravels==null){
						ptravels=new Vector<Travel>();
						travels.put(travel.getOrigin(),ptravels);
					}
					ptravels.add(travel);
				}
			
				i++;
			}
		}
		
	}
	
	@Override
	public String execute() {
		try{
			HashMap<Integer,Integer> planetMinTravel=new HashMap<Integer, Integer>();
			planetMinTravel.put(origin, 25000);//yeah... It's a constant, so what? is this a contest?
			//Thanks Dijkstra ;) (kind of)
			Vector<Integer>leftPlanets=new Vector<Integer>();
			Vector<Integer>visitedPlanet=new Vector<Integer>();
			leftPlanets.add(origin);
			while(!leftPlanets.isEmpty()){
				int actualPlanet=-1;
				//We choose the planet with the minimun distance
				Integer minDist=null;
				for(Integer planet:leftPlanets){
					if(minDist==null){
						minDist=planetMinTravel.get(planet);
						if(minDist!=null){
							actualPlanet=planet;
						}
					}
					Integer dist=planetMinTravel.get(planet);
					if(dist!=null&&minDist>dist){
						actualPlanet=planet;
						minDist=dist;
					}
				}
				leftPlanets.remove((Integer)actualPlanet);
				visitedPlanet.add(actualPlanet);
				int actualWeight=planetMinTravel.get(actualPlanet);
				List<Travel>travelList=travels.get(actualPlanet);
				if(travelList!=null){
					for(Travel travel:travelList){
						//We supose that the origin is the OK in the hashmap
						int newPlanet=travel.getDestination();
						int totalTravelWeight=actualWeight+travel.getTimeCost();
						Integer lastPlanetWeight=planetMinTravel.get(newPlanet);
						if(lastPlanetWeight==null||totalTravelWeight<lastPlanetWeight){
							if(newPlanet==this.origin){
								//We can travel back time... BAZINGA!
								planetMinTravel.clear();
								leftPlanets.clear();
								break;
							}
							planetMinTravel.put(newPlanet, totalTravelWeight);
							if(!leftPlanets.contains(newPlanet)){
								leftPlanets.add(newPlanet);
							}
						}
							
					}
				}
			}
			Integer solution=planetMinTravel.get(destination);
			return solution!=null?solution+"":"BAZINGA";
			
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
