package net.tuenti.contest.igbopie.gasstations;

import java.io.IOException;
import java.util.Scanner;

import net.tuenti.contest.igbopie.services.ExecutorService;
import net.tuenti.contest.igbopie.services.ServiceLocator;


/**
 * This class is the main class. It calculates the first time the prime numbers,
 *  but then, it caches the series so it does not have to recalculate it again.
 * @author igbopie
 *
 */
public class GasStations {

	/**
	 * The main execution of the program
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[]args) throws IOException{
		
		
		Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		ExecutorService executorService=ServiceLocator.getExecutorService();
		String line=scanner.nextLine();
		int n=Integer.parseInt(line.trim());
		for(int i=0;i<n;i++){
			int autonomy=Integer.parseInt(scanner.nextLine());
			int distanceToTravel=Integer.parseInt(scanner.nextLine());
			int nGasStations=Integer.parseInt(scanner.nextLine());
			String gasStations=scanner.nextLine();
			GasStationCommand cmd=new GasStationCommand(autonomy,distanceToTravel,nGasStations,gasStations);
			executorService.execute(cmd);
		}
		
		
			
		
		
	}
}
