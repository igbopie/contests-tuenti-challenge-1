package net.tuenti.contest.igbopie.theclock.model.entity;

public class Clock {

	private int seconds;
	private int minutes;
	private int hours;
	public Clock() {
		super();
		seconds=0;
		minutes=0;
		hours=0;
		
	}
	public void addSecond(){
		seconds++;
		if(seconds>=60){
			seconds=0;
			minutes++;
			if(minutes>=60){
				minutes=0;
				hours++;
				if(hours>=24){//24hoursclock
					hours=0;
				}
			}
		}
	}
	public int getValue(){
		StringBuffer format=new StringBuffer();
		format.append(seconds);
		if(format.length()<2){
			format.append("0");
		}
		format.append(minutes);
		if(format.length()<4){
			format.append("0");
		}
		format.append(hours);
		if(format.length()<6){
			format.append("0");
		}
		int value=0;
		for(Character c:format.toString().toCharArray()){
			switch(c){
			case '1':
				value+=2;
				break;
			case '7':
				value+=3;
				break;
			case '4':
				value+=4;
				break;
			case '2':
			case '3':
			case '5':
				value+=5;
				break;
			case '0':
			case '6':
			case '9':
				value+=6;
				break;
			case '8':
				value+=7;//ALL LEDS!
				break;
			}
		}
	
		return value;
		
		
	}
			
		
}
