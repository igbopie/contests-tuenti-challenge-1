package net.tuenti.contest.igbopie.thebiologistproblem;

import net.tuenti.contest.igbopie.services.Command;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TheBiologistProblemCommand implements Command{
	private String line;

	public TheBiologistProblemCommand(String line){
		this.line=line;
	}
	
	@Override
	public String execute() {
		try{
			String[]tokens=line.split(" ");
			String dnaA=tokens[0];
			String dnaB=tokens[1];
			String biggestCohincidence="";
			
			for(int i=0;i<dnaA.length();i++){
				for(int j=0;j<dnaB.length();j++){
					if(dnaA.charAt(i)==dnaB.charAt(j)){
						//We have a match!
						String match="";
						int offsetA=i;
						int offsetB=j;
						while(offsetA<dnaA.length()&&offsetB<dnaB.length()&&dnaA.charAt(offsetA)==dnaB.charAt(offsetB)){
							match+=dnaA.charAt(offsetA);
							offsetA++;
							offsetB++;
						}	
						if(match.length()>biggestCohincidence.length()){
							biggestCohincidence=match;
						}
					}
				}
				
			}
			return biggestCohincidence;
		
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
