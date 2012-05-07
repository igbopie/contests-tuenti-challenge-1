package net.tuenti.contest.igbopie.thetilegame;

import java.io.IOException;

import net.tuenti.contest.igbopie.thetilegame.model.entity.State;


/**
 * This class is the main class. It calculates the first time the prime numbers,
 *  but then, it caches the series so it does not have to recalculate it again.
 * @author igbopie
 *
 */
public class TheTileGame {

	/**
	 * The main execution of the program
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[]args) throws IOException{
		
		int[]prices={1,1,1};
		State state=new State("abcd", "   abcd", prices);
		System.out.println(state.finished());
		/*Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		ExecutorService executorService=ServiceLocator.getExecutorService();
		while(scanner.hasNext()){
			String line=scanner.nextLine();
			TheTileGameCommand cmd=new TheTileGameCommand(line);
			executorService.execute(cmd);
		}*/
	}
}
