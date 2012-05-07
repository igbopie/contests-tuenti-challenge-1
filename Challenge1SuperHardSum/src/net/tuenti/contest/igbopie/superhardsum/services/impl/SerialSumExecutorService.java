package net.tuenti.contest.igbopie.superhardsum.services.impl;

import net.tuenti.contest.igbopie.superhardsum.services.SumExecutorService;
import net.tuenti.contest.igbopie.superhardsum.util.SuperHardSumUtil;

public class SerialSumExecutorService implements SumExecutorService{
	
	@Override
	public void executeSum(String[] numbers) {
		System.out.println(SuperHardSumUtil.sum(numbers));
	}
}
