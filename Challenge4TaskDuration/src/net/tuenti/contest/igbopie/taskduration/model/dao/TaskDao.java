package net.tuenti.contest.igbopie.taskduration.model.dao;

import net.tuenti.contest.igbopie.taskduration.model.entity.Task;

public interface TaskDao {
	
	public Task getTask(String id);
	public Task saveTask(Task task);
	public void removeTask(Task task);
	public int getDuration(String id);

}
