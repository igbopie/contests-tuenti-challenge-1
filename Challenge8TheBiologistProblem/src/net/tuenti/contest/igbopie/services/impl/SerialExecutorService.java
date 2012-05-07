package net.tuenti.contest.igbopie.services.impl;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.services.ExecutorService;

public class SerialExecutorService implements ExecutorService{
	
	@Override
	public void execute(Command command) {
		System.out.println(command.execute());
	}
}
