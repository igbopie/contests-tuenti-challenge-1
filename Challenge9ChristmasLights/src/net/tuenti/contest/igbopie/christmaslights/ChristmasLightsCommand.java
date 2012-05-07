package net.tuenti.contest.igbopie.christmaslights;

import java.util.List;
import java.util.Vector;

import net.tuenti.contest.igbopie.services.Command;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class ChristmasLightsCommand implements Command{
	private int nlights;
	private int timeLimit;

	public ChristmasLightsCommand(int nlights,int timeLimit){
		this.nlights=nlights;
		this.timeLimit=timeLimit;
	}
	
	@Override
	public String execute() {
		try{
			String nolights="All lights are off :(";
			int time=1;
			int totalLength=0;
			List<Integer>evenSeq=new Vector<Integer>();
			List<Integer>oddSeq=new Vector<Integer>();
			for(;time<=timeLimit&&totalLength<nlights;time++,totalLength++){
				int num=time-1;
				if(num%2==0){
					evenSeq.add(num);
				}else{
					oddSeq.add(num);
				}
			}
			String end="";
			if(timeLimit%2!=0){
				end= evenSeq.toString();
			}else{
				end= oddSeq.toString();
			}
			end=end.replaceAll("[\\[\\],]", "");
			if(end.equalsIgnoreCase("")){
				return nolights;
			}
			return end;
			
		
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
