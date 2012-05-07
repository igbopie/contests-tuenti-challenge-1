package net.tuenti.contest.igbopie.theotherclock.model.entity;

public class OtherClock {

	private int seconds;
	private int minutes;
	private int hours;
	private int energy;
	//   2
	//  ------
	// 3|	 |1
	//  --6---
	// 4| 	 |0
	//  ------
	//     5 
	public static String CERO="1111110";

	//   2
	//  
	// 3	 |1
	//     6
	// 4 	 |0
	//  
	//     5 
	public static String ONE="1100000";

	//   2
	//  ------
	// 3	 |1
	//  --6---
	// 4| 	  0
	//  ------
	//     5 
	public static String TWO="0110111";

	//   2
	//  ------
	// 3	 |1
	//  --6---
	// 4 	 |0
	//  ------
	//     5 
	public static String THREE="1110011";

	//   2
	//  
	// 3|	 |1
	//  --6---
	// 4 	 |0
	//  
	//     5 
	public static String FOUR="1101001";
	//   2
	//  ------
	// 3|	 1
	//  --6---
	// 4 	 |0
	//  ------
	//     5 
	public static String FIVE="1011011";
	//   2
	//  ------
	// 3|	 1
	//  --6---
	// 4| 	 |0
	//  ------
	//     5 
	public static String SIX="1011111";
	//   2
	//  ------
	// 3	 |1
	//    6
	// 4 	 |0
	//  
	//     5 
	public static String SEVEN="1110000";
	//   2
	//  ------
	// 3|	 |1
	//  --6---
	// 4| 	 |0
	//  ------
	//     5 
	public static String EIGHT="1111111";
	//   2
	//  ------
	// 3|	 |1
	//  --6---
	// 4 	 |0
	//  ------
	//     5 
	public static String NINE="1111011";
	//I can model the leds, so I can calculate the diference, 
	//but... will create a processing overhead. We will store
	//manually the results.. Maintenance VS Performance
	//for this case I prefer performance (my clock is not going to change!)
	//NOTE: At the end I change it and load at the beginning.
	private int[][]transitionValues;
	public OtherClock() {
		super();
		calcTransitionValues();
		seconds=0;
		minutes=0;
		hours=0;
		energy=this.calcEnergy(this.getFormat());
	}
	
	
	private void calcTransitionValues(){
		transitionValues=new int[10][10];
		for(int i=0;i<transitionValues.length;i++){
			for(int j=0;j<transitionValues[i].length;j++){
				String iP=takePattern(i);
				String jP=takePattern(j);
				int value=0;
				for(int z=0;z<iP.length();z++){
					if(iP.charAt(z)!=jP.charAt(z)&&iP.charAt(z)=='0'){//only turning on!
						value++;
					}
				}
				transitionValues[i][j]=value;
			}
		}
	}
	
	private String takePattern(int i){
		switch(i){
		case 0:
			return CERO;
		case 1:
			return ONE;
		case 2:
			return TWO;
		case 3:
			return THREE;
		case 4:
			return FOUR;
		case 5:
			return FIVE;
		case 6:
			return SIX;
		case 7:
			return SEVEN;
		case 8:
			return EIGHT;
		case 9:
			return NINE;
		}
		return "0000000";
	}
	public void addSecond(){
		String oldFormat=this.getFormat();
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
		String newFormat=this.getFormat();
		for(int z=0;z<newFormat.length();z++){
			energy+=this.evalCommingDigit(oldFormat.charAt(z),newFormat.charAt(z));
		}
	}
	private String getFormat(){
		StringBuffer format=new StringBuffer();
		if(minutes<10){
			format.append("0");
		}
		format.append(minutes);

		if(hours<10){
			format.append("0");
		}
		format.append(hours);
		
		if(seconds<10){
			format.append("0");
		}
		format.append(seconds);
			
		return format.toString();
	}


	private int calcEnergy(String format){
		int value=0;
		for(Character c:format.toString().toCharArray()){
			value+=this.evalInitDigit(c);
		}
		return value;
	}
	private int evalCommingDigit(char a,char b){
		return transitionValues[(a-'0')][b-'0'];//manual Integer.parseInt
		
	}
	private int evalInitDigit(char c){
		switch(c){
		case '1':
			return 2;
		case '7':
			return 3;
		case '4':
			return 4;
		case '2':
		case '3':
		case '5':
			return 5;
		case '0':
		case '6':
		case '9':
			return 6;
		case '8':
			return 7;//ALL LEDS!
		}
		return 0;
	}
	public int getEnergy(){
		return energy;


	}


}
