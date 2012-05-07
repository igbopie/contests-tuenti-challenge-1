package net.tuenti.contest.igbopie.thetilegame;

import net.tuenti.contest.igbopie.services.Command;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TheTileGameCommand implements Command{
	private String line;

	public TheTileGameCommand(String line){
		this.line=line;
	}
	
	@Override
	public String execute() {
		try{
			String[]tokens=line.split(" ");
			String startState=tokens[0];
			String finalState=tokens[1];
			String[]operationPrices=tokens[2].split(",");
			int addPrice=Integer.parseInt(operationPrices[0]);
			int removePrice=Integer.parseInt(operationPrices[1]);
			int replacePrice=Integer.parseInt(operationPrices[2]);
			int replaceMacroPrice=addPrice+removePrice;
			replacePrice=replacePrice<replaceMacroPrice?replacePrice:replaceMacroPrice;
			
			int maxLength=startState.length()>finalState.length()?startState.length():finalState.length();
			int minPrice=-1;
			//we go through all the offsets
			int offset=maxLength;
			for(int i=0;i<(maxLength*2);i++){
				
				int priceOffset=0;
				//we compare each position
				for(int j=0;j<startState.length();j++){
					int startStatePos=j;
					int finalStatePos=j+offset;
					if(finalStatePos>=finalState.length()){
						
					}
					
				}
				if(minPrice==-1&&priceOffset<minPrice){
					minPrice=priceOffset;
				}
		
				offset++;
			}
			
			
			return ""+minPrice;
		
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
