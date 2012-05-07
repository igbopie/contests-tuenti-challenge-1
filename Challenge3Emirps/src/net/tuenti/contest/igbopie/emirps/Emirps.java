package net.tuenti.contest.igbopie.emirps;

import java.util.Scanner;

import net.tuenti.contest.igbopie.services.ExecutorService;
import net.tuenti.contest.igbopie.services.ServiceLocator;

/**
 * This class is the main class. It calculates the first time the prime numbers,
 *  but then, it caches the series so it does not have to recalculate it again.
 * @author igbopie
 *
 */
public class Emirps {

	/**
	 * The main execution of the program
	 * @param args
	 */
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		ExecutorService executorService=ServiceLocator.getExecutorService();
		while(scanner.hasNext()){
			EmirpsCommand command=new EmirpsCommand(scanner.nextLine());
			executorService.execute(command);
		}
	}
}
