package net.tuenti.contest.igbopie.emirps;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.services.ServiceLocator;
/**
 * It reads tuenti language. Tuenti language is similar to Lisp(http://es.wikipedia.org/wiki/Lisp)
 * @author ignaciobonapiedrabuena
 *
 */
public class EmirpsCommand implements Command{

	private String line;
	public EmirpsCommand(String line){
		this.line=line;
	}

	@Override
	public String execute() {
		try{
			//EmirpsService is kind of a singleton. It caches the emirps numbers series.
			return ServiceLocator.getEmirpsService().getSumEmirpsTo(line);
		}catch(Exception e){
			return "E:"+e;
		}
	}
}
