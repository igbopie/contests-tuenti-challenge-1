package net.tuenti.contest.igbopie.keycombos;

import net.tuenti.contest.igbopie.keycombos.model.dao.KeyCombosDaoImpl;
import net.tuenti.contest.igbopie.keycombos.model.entity.KeyCombo;
import net.tuenti.contest.igbopie.services.Command;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class KeyCombosCommand implements Command{
	private KeyCombosDaoImpl dao;
	private String line;

	public KeyCombosCommand(KeyCombosDaoImpl dao, String line){
		this.dao=dao;
		this.line=line;
	}
	
	@Override
	public String execute() {
		try{
			/*Like a google search :P */
			KeyCombo kc=dao.search(line);
			if(kc!=null){
				return kc.getAction();
			}else{
				return "E:NOT FOUND";
			}
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
