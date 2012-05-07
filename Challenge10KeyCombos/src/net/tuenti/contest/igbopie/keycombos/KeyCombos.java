package net.tuenti.contest.igbopie.keycombos;

import java.io.IOException;
import java.util.Scanner;

import net.tuenti.contest.igbopie.keycombos.model.dao.KeyCombosDaoImpl;
import net.tuenti.contest.igbopie.keycombos.model.entity.KeyCombo;
import net.tuenti.contest.igbopie.services.ExecutorService;
import net.tuenti.contest.igbopie.services.ServiceLocator;


/**
 * This class is the main class. It calculates the first time the prime numbers,
 *  but then, it caches the series so it does not have to recalculate it again.
 * @author igbopie
 *
 */
public class KeyCombos {

	/**
	 * The main execution of the program
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[]args) throws IOException{
		
		
		Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		ExecutorService executorService=ServiceLocator.getExecutorService();
		KeyCombosDaoImpl combosDaoImpl=new KeyCombosDaoImpl();
		String line=scanner.nextLine();
		int nKeyCombos=Integer.parseInt(line.trim());
		for(int i=0;i<nKeyCombos;i++){
			String commands=scanner.nextLine();
			String action=scanner.nextLine();
			KeyCombo kc=new KeyCombo();
			kc.setAction(action);
			kc.setCommands(commands);
			combosDaoImpl.save(kc);
		}
		line=scanner.nextLine();
		int nProblems=Integer.parseInt(line.trim());
		for(int i=0;i<nProblems;i++){
			KeyCombosCommand cmd=new KeyCombosCommand(combosDaoImpl,scanner.nextLine());
			executorService.execute(cmd);
		}
		
		
			
		
		
	}
}
