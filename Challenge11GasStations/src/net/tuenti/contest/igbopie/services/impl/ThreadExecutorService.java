package net.tuenti.contest.igbopie.services.impl;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.services.ExecutorService;
/**
 * This class will execute the commands using threads.
 * @author ignaciobonapiedrabuena
 *
 */
public class ThreadExecutorService implements Observer,ExecutorService{
	
	public static int MAX_THREADS=8;
	public Stack<CommandThread>cueThreads;
	public HashMap<Integer,String>results;
	private int nProcess;
	private int nProcessing;
	private int nProcessed;
	public ThreadExecutorService(){
		nProcess=0;
		nProcessing=0;
		nProcessed=0;
		cueThreads=new Stack<CommandThread>();
		results=new HashMap<Integer,String>();
	}
	@Override
	public void update(Observable o, Object arg) {
		CommandThread st=(CommandThread)o;
		results.put(st.getIndex(),st.getResult());
		synchronized (this) {
			nProcessing--;
		}
		checkStatus();
	}
	
	private synchronized void checkStatus(){
		while(nProcessing<=MAX_THREADS&&!cueThreads.empty()){
			CommandThread st=cueThreads.pop();
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
	public void execute(Command command) {
		CommandThread st=new CommandThread(command,nProcess);
		st.addObserver(this);
		nProcess++;
		cueThreads.push(st);
		checkStatus();
	}
	
	
	
	
	
	

}
