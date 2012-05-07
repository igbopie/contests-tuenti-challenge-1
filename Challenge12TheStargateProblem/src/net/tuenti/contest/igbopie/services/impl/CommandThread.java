package net.tuenti.contest.igbopie.services.impl;

import java.util.Observable;

import net.tuenti.contest.igbopie.services.Command;

public class CommandThread extends Observable implements Runnable{
    private Command command;
    private String result;
    private int index;
    CommandThread(Command command,int index) {
        this.command=command;
        this.index=index;
    }

    public void run() {
    	result=command.execute();
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