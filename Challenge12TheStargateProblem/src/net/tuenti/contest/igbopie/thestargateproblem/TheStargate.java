package net.tuenti.contest.igbopie.thestargateproblem;

import java.io.IOException;
import java.util.Scanner;

import net.tuenti.contest.igbopie.services.ExecutorService;
import net.tuenti.contest.igbopie.services.ServiceLocator;


/**
 * @author igbopie
 *
 */
public class TheStargate {

	/**
	 * The main execution of the program
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[]args) throws IOException{
		
		
		Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		ExecutorService executorService=ServiceLocator.getExecutorService();
		while(scanner.hasNext()){
			TheStargateCommand cmd=new TheStargateCommand(scanner.nextLine());
			executorService.execute(cmd);
		}
		
		
	}
}
