package net.tuenti.contest.igbopie.superhardsum.services;

import net.tuenti.contest.igbopie.superhardsum.services.impl.ThreadSumExecutorService;
/**
 * Factory class. It give us the real implementation of SumExecutorService
 * @author ignaciobonapiedrabuena
 *
 */
public class ServiceLocator {
	public static SumExecutorService getSumExecutorService(){
		return new ThreadSumExecutorService();
	}

}
