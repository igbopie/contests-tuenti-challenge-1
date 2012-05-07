package net.tuenti.contest.igbopie.theclock;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.theclock.model.entity.Clock;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TheClockCommand implements Command{
	private String line;

	public TheClockCommand(String line){
		this.line=line;
	}
	
	@Override
	public String execute() {
		try{
			Clock clock=new Clock();
			int value=clock.getValue();
			int totalSeconds=Integer.parseInt(line);
			for(int i=0;i<totalSeconds;i++){
				clock.addSecond();
				value+=clock.getValue();
			}
			return ""+value;
		
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
