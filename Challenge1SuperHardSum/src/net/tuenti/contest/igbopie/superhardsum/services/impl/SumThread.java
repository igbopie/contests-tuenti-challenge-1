package net.tuenti.contest.igbopie.superhardsum.services.impl;

import java.util.Observable;

import net.tuenti.contest.igbopie.superhardsum.util.SuperHardSumUtil;

public class SumThread extends Observable implements Runnable{
    private String[]numbers;
    private String result;
    private int index;
    SumThread(String[]numbers,int index) {
        this.numbers=numbers;
        this.index=index;
    }

    public void run() {
        // compute primes larger than minPrime
        result=SuperHardSumUtil.sum(numbers);
        this.setChanged();
        this.notifyObservers();
    }
    public void printResult(){
   	 System.out.println(result);
    }
    
    public int getIndex(){
    	return index;
    }
	public String getResult(){
		return result;
	}
}