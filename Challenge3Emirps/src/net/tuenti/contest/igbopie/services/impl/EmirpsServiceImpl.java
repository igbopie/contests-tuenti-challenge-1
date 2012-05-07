package net.tuenti.contest.igbopie.services.impl;

import java.util.Collection;
import java.util.Vector;

import net.tuenti.contest.igbopie.services.EmirpsService;
import net.tuenti.contest.igbopie.util.Util;

public class EmirpsServiceImpl implements EmirpsService{
	private Collection<Integer>emirps;
	public static final int FIRST_EMIRPS=13;
	
	public EmirpsServiceImpl(){
		emirps=new Vector<Integer>();
		emirps.add(FIRST_EMIRPS);
	}

	@Override
	public String getSumEmirpsTo(String number) {
		int i=FIRST_EMIRPS;
		int n=Integer.parseInt(number);
		int result=0;
		//Cached results!
		for(Integer em:emirps){
			i=em;
			if(em>n){
				break;
			}
			result+=em;
		}
		i=Util.nextEmirps(i);
		synchronized (emirps) {
			emirps.add(i);
		}
		//No cached results
		while(i<=n){
			result+=i;
			i=Util.nextEmirps(i);
			synchronized (emirps) {
				emirps.add(i);
			}
		}
		return result+"";
	}

}
