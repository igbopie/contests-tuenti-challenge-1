package net.tuenti.contest.igbopie.tlang;

import java.util.Scanner;

import net.tuenti.contest.igbopie.services.ExecutorService;
import net.tuenti.contest.igbopie.services.ServiceLocator;

/**
 * This class is the main class. It reads tuenti language.
 * @author igbopie
 *
 */
public class TLang {

	/**
	 * The main execution of the program
	 * @param args
	 */
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		ExecutorService executorService=ServiceLocator.getExecutorService();
		while(scanner.hasNext()){
			TLangCommand command=new TLangCommand(scanner.nextLine());
			executorService.execute(command);
		}
	}
}
