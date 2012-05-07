package net.tuenti.contest.igbopie.thetilegame.model.entity;

public class State {
	private String state;
	private String finalState;
	private int price;
	private int[]prices;
	public State(String state, String finalState, int[] prices) {
		super();
		this.state = state;
		this.finalState = finalState;
		this.prices = prices;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public State cloneState(){
		State stateClone= new State(new String(state),new String(finalState),prices);
		stateClone.price=this.price;
		return stateClone;
		
	}
	public boolean add(int pos,char character){
		if(pos<0||pos>state.length()){
			return false;
		}
		String fstate=state.substring(0, pos);
		fstate+=character;
		if(pos!=state.length()){
			fstate+=state.substring(pos, state.length());
		}
		state=fstate;
		price+=prices[0];
		return true;
		
	}
	public boolean remove(int pos){
		if(pos<0||pos>state.length()-1){
			return false;
		}
		String fstate=state.substring(0, pos);
		if(pos!=state.length()){
			fstate+=state.substring(pos+1, state.length());
		}
		state=fstate;
		price+=prices[1];
		return true;
		
	}
	public boolean replace(int pos,char character){
		if(pos<0||pos>state.length()-1){
			return false;
		}
		String fstate=state.substring(0, pos);
		fstate+=character;
		if(pos!=state.length()){
			fstate+=state.substring(pos+1, state.length());
		}
		state=fstate;
		price+=prices[2];
		return true;
		
	}
	public int getPoints() {
		int points=0;
		for(int i =0;i<state.length()&&i<finalState.length();i++){
			if(state.charAt(i)==finalState.charAt(i)&&state.charAt(i)!=' '){
				points++;
			}
		}
		return points;
	}
	public boolean finished(){
		String tstate=state.trim();
		String tfstate=finalState.trim();
		if(tstate.equals(tfstate)){
			return true;
		}else{
			return false;
		}
		
	}

}
