package net.tuenti.contest.igbopie.taskduration.model.entity;

import java.util.List;
import java.util.Vector;

public class Task {
	private String id;
	private String duration;
	private List<Task>dependencies;
	
	public Task(String id, String duration) {
		super();
		this.id = id;
		this.duration = duration;
		this.dependencies = new Vector<Task>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void addDependency(Task task){
		dependencies.add(task);
	}
	public List<Task> getDependencies() {
		return dependencies;
	}
	public void setDependencies(List<Task> dependencies) {
		this.dependencies = dependencies;
	}
	

}
