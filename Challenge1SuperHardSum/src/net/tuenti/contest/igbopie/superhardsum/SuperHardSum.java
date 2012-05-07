package net.tuenti.contest.igbopie.superhardsum;

import java.util.Scanner;

import net.tuenti.contest.igbopie.superhardsum.services.ServiceLocator;
import net.tuenti.contest.igbopie.superhardsum.services.SumExecutorService;

/**
 * This class is the main class. It sums a list of numbers given by the input.
 * @author igbopie
 *
 */
public class SuperHardSum {

	/**
	 * The main execution of the program
	 * @param args
	 */
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		SumExecutorService tc=ServiceLocator.getSumExecutorService();
		while(scanner.hasNext()){
			String[] numbers=scanner.nextLine().split(" ");
			tc.executeSum(numbers);
		}
	}

}
