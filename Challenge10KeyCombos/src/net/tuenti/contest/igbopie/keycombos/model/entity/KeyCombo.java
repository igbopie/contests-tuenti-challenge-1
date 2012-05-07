package net.tuenti.contest.igbopie.keycombos.model.entity;

import java.util.List;
import java.util.Vector;

public class KeyCombo {
	private List<String>commands;
	private String action;
	
	public List<String> getCommands() {
		return commands;
	}
	public void setCommands(List<String> commands) {
		this.commands = commands;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action.trim();
	}
	public void setCommands(String commandsString){
		commands=new Vector<String>();
		for(String cmd:commandsString.split(" ")){
			commands.add(cmd);
		}
	}
	
	
	public boolean equals(Object object){
		
		if(object instanceof KeyCombo){
			KeyCombo other=(KeyCombo) object;
			return other.getCommands().containsAll(commands)&&commands.containsAll(other.getCommands());
		}
		return false;
		
	}
	
	
	

}
