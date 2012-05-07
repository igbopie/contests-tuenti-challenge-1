package net.tuenti.contest.igbopie.keycombos.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import net.tuenti.contest.igbopie.keycombos.model.entity.KeyCombo;

public class KeyCombosDaoImpl {
	private HashMap<String,List<KeyCombo>>index;
	
	public KeyCombosDaoImpl(){
		index=new HashMap<String, List<KeyCombo>>();
	}
	
	public KeyCombo search(String keys){
		List<KeyCombo>results = null;
		for(String key:keys.split(" ")){
			if(results==null){
				results=new Vector<KeyCombo>(index.get(key));
			}else{
				//DO INTERSECTION
				List<KeyCombo>resultsKey =new Vector<KeyCombo>(index.get(key));
				results.retainAll(resultsKey);
			}
		}
		if(results!=null&&results.size()>0){
			return results.get(0);
		}else{
			return null;
		}
	}
	
	public void save(KeyCombo combo){
		List<String>combokeys=combo.getCommands();
		
		for(String comboKey:combokeys){
			List<KeyCombo>combokeysMapped=index.get(comboKey);
			if(combokeysMapped==null){
				//NO ENTRY SO WE CREATE IT
				combokeysMapped=new Vector<KeyCombo>();
			}
			combokeysMapped.add(combo);
			index.remove(comboKey);
			index.put(comboKey, combokeysMapped);
		}
	}

}
