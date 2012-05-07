package net.tuenti.contest.igbopie.taskduration;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.taskduration.model.dao.TaskDao;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TaskDurationCommand implements Command{
	private TaskDao taskDao;
	private String id;

	public TaskDurationCommand(TaskDao taskDao,String id){
		this.taskDao=taskDao;
		this.id=id;
	}

	@Override
	public String execute() {
		try{
			return id+" "+taskDao.getDuration(id);
		}catch(Exception e){
			return "E:"+e;
		}
	}
}
