package net.tuenti.contest.igbopie.services;

import net.tuenti.contest.igbopie.services.impl.EmirpsServiceImpl;
import net.tuenti.contest.igbopie.services.impl.ThreadExecutorService;
/**
 * Factory class. It give us the real implementation of ExecutorService
 * @author ignaciobonapiedrabuena
 *
 */
public class ServiceLocator {
	
	private static EmirpsService emirpsServiceSingleton=new EmirpsServiceImpl();
	
	public static ExecutorService getExecutorService(){
		return new ThreadExecutorService();
	}
	public static EmirpsService getEmirpsService(){
		return emirpsServiceSingleton;
	}

}
