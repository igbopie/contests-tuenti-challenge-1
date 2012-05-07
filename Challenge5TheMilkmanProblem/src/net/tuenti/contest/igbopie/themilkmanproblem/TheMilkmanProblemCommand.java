package net.tuenti.contest.igbopie.themilkmanproblem;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.themilkmanproblem.model.entity.Cow;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TheMilkmanProblemCommand implements Command{
	private String line;

	public TheMilkmanProblemCommand(String line){
		this.line=line;
	}
	/**
	 * We are going to create a binary map where it's decided which cow is taken.
	 * 100001: We take the first cow and the last cow.
	 */
	@Override
	public String execute() {
		try{

			String[] tokens=line.split(" ");
			int nCows=Integer.parseInt(tokens[0]);
			int maxWeight=Integer.parseInt(tokens[1]);
			Cow[]cows=new Cow[nCows];
			String[]cowsWeight=tokens[2].split(",");
			String[]cowsProduction=tokens[3].split(",");
			for(int i=0;i<nCows;i++){
				cows[i]=new Cow(Integer.parseInt(cowsWeight[i]),Integer.parseInt(cowsProduction[i]));
			}
			int posibleSolutions=(int) Math.pow(2, nCows);
			int maxProduction=0;
			for(int i=0;i<posibleSolutions;i++){
				String binArray=Integer.toBinaryString(i);
				int weight=0;
				int prod=0;

				for(int j=0;j<nCows;j++){
					int realStringPos=binArray.length()-nCows+j;
					if(realStringPos>=0){
						switch(binArray.charAt(realStringPos)){
						case '1':
							prod+=cows[j].getProduction();
							weight+=cows[j].getWeight();
							break;

						}
					}
				}
				if(weight<=maxWeight&&maxProduction<prod){
					maxProduction=prod;
				}

			}

			//NOW WE SOLVE THE PROBLEM
			return ""+maxProduction;


		}catch(Exception e){
			return "E:"+e;
		}
	}

}
