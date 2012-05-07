package net.tuenti.contest.igbopie.services;

import net.tuenti.contest.igbopie.services.impl.ThreadExecutorService;
/**
 * Factory class. It give us the real implementation of ExecutorService
 * @author ignaciobonapiedrabuena
 *
 */
public class ServiceLocator {
	public static ExecutorService getExecutorService(){
		return new ThreadExecutorService();
	}

}
