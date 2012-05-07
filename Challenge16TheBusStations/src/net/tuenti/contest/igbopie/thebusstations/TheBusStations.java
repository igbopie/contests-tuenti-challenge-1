package net.tuenti.contest.igbopie.thebusstations;

import java.io.IOException;
import java.util.Scanner;

import net.tuenti.contest.igbopie.services.ExecutorService;
import net.tuenti.contest.igbopie.services.ServiceLocator;


/**
 * @author igbopie
 *
 */
public class TheBusStations {

	/**
	 * The main execution of the program
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[]args) throws IOException{
		//System.out.println("1387");
		
		Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		ExecutorService executorService=ServiceLocator.getExecutorService();
		while(scanner.hasNext()){
			TheBusStationsCommand cmd=new TheBusStationsCommand(scanner.nextLine());
			executorService.execute(cmd);
		}
		
		
	}
}
