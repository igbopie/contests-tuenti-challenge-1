package net.tuenti.contest.igbopie.taskduration;

import java.io.IOException;
import java.util.Scanner;

import net.tuenti.contest.igbopie.services.ExecutorService;
import net.tuenti.contest.igbopie.services.ServiceLocator;
import net.tuenti.contest.igbopie.taskduration.model.dao.impl.TaskDaoBigFilesImpl;


/**
 * This class is the main class. It calculates the first time the prime numbers,
 *  but then, it caches the series so it does not have to recalculate it again.
 * @author igbopie
 *
 */
public class TaskDuration {

	/**
	 * The main execution of the program
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[]args) throws IOException{
		TaskDaoBigFilesImpl taskDao=new TaskDaoBigFilesImpl();
		taskDao.readFile(args[0]);
		Scanner scanner = new Scanner(System.in);
		// ServiceLocator decide which implementation use
		ExecutorService executorService=ServiceLocator.getExecutorService();
		while(scanner.hasNext()){
			String line=scanner.nextLine();
			for(String token:line.split(",")){
				TaskDurationCommand command=new TaskDurationCommand(taskDao,token);
				executorService.execute(command);
			}
		}
	}
}
