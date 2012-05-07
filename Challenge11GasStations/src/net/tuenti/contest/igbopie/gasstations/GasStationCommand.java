package net.tuenti.contest.igbopie.gasstations;

import net.tuenti.contest.igbopie.services.Command;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class GasStationCommand implements Command{
	private int autonomy;
	private int distanceToTravel;
	private int nGasStations;
	private String gasStations;

	public GasStationCommand(int autonomy,int distanceToTravel,int nGasStations,String gasStations){
		this.autonomy=autonomy;
		this.distanceToTravel=distanceToTravel;
		this.nGasStations=nGasStations;
		this.gasStations=gasStations;
	}
	
	@Override
	public String execute() {
		try{
			if(autonomy>=distanceToTravel){
				return "No stops";
			}
			int distanceTravelled=0;
			int distanceTravelledLastStop=0;
			int lastGasStation=0;
			StringBuffer gasStationStopped=new StringBuffer();
			//We supponse they are ordered
			for(String gasStationString:gasStations.split(" ")){
				int gasStation=Integer.parseInt(gasStationString);
				if(distanceTravelled>=distanceToTravel){
					break;
				}
				int dif=gasStation-lastGasStation;
				distanceTravelled+=dif;
				distanceTravelledLastStop+=dif;
				if(distanceTravelledLastStop>autonomy){
					distanceTravelledLastStop=dif;
					gasStationStopped.append(lastGasStation);
					gasStationStopped.append(" ");
				}
				lastGasStation=gasStation;
				
			}
			return gasStationStopped.toString().trim();
			
			
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
