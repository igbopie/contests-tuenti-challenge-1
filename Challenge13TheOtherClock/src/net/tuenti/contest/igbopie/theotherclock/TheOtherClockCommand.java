package net.tuenti.contest.igbopie.theotherclock;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.theotherclock.model.entity.OtherClock;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TheOtherClockCommand implements Command{
	private String line;

	public TheOtherClockCommand(String line){
		this.line=line;
	}
	
	@Override
	public String execute() {
		try{
			OtherClock clock=new OtherClock();
			int totalSeconds=Integer.parseInt(line);
			for(int i=0;i<totalSeconds;i++){
				clock.addSecond();
			}
			return ""+clock.getEnergy();
		
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
