package net.tuenti.contest.igbopie.christmaslights;

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
public class ChristmasLights {

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
		int nProblems=Integer.parseInt(line);
		for(int i=0;i<nProblems;i++){
			String nLights=scanner.nextLine();
			String time=scanner.nextLine();
			ChristmasLightsCommand cmd=new ChristmasLightsCommand(Integer.parseInt(nLights),Integer.parseInt(time));
			executorService.execute(cmd);
		}
		
	}
}
