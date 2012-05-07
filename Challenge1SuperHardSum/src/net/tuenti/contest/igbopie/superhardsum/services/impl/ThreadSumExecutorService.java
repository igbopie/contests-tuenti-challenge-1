package net.tuenti.contest.igbopie.superhardsum.services.impl;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import net.tuenti.contest.igbopie.superhardsum.services.SumExecutorService;
/**
 * This class will sum the numbers using threads.
 * @author ignaciobonapiedrabuena
 *
 */
public class ThreadSumExecutorService implements Observer,SumExecutorService{
	
	public static int MAX_THREADS=8;
	public Stack<SumThread>cueThreads;
	public HashMap<Integer,String>results;
	private int nProcess;
	private int nProcessing;
	private int nProcessed;
	public ThreadSumExecutorService(){
		nProcess=0;
		nProcessing=0;
		nProcessed=0;
		cueThreads=new Stack<SumThread>();
		results=new HashMap<Integer,String>();
	}
	@Override
	public void update(Observable o, Object arg) {
		SumThread st=(SumThread)o;
		results.put(st.getIndex(),st.getResult());
		synchronized (this) {
			nProcessing--;
		}
		checkStatus();
	}
	
	private synchronized void checkStatus(){
		while(nProcessing<=MAX_THREADS&&!cueThreads.empty()){
			SumThread st=cueThreads.pop();
			Thread t=new Thread(st);
			t.start();
			nProcessing++;
		}	
		String process;
		while((process=results.get(nProcessed))!=null){
			System.out.println(process);
			nProcessed++;
		}
	}
	@Override
	public void executeSum(String[] numbers) {
		SumThread st=new SumThread(numbers,nProcess);
		st.addObserver(this);
		nProcess++;
		cueThreads.push(st);
		checkStatus();
	}
	
	
	
	
	
	

}
