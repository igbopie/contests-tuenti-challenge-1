package net.tuenti.contest.igbopie.util;

import java.math.BigInteger;
import java.util.Collection;
/**
 * This is a utility class with some useful methods.
 * @author ignaciobonapiedrabuena
 *
 */
public class Util {
	/**
	 * Util function to check if a string is not empty or null
	 * @param string
	 * @return
	 */
	public static boolean notEmpty(String string){
		return string!=null&!string.trim().equalsIgnoreCase("");
	}
	/**
	 * Util function to check if a number is too long to be a int
	 * @param string
	 * @return
	 */
	public static boolean bigString(String string){
		return string.length()>9;
	}
	/**
	 * Util function to remove some invalid chars.
	 * @param string
	 * @return
	 */
	public static String parseString(String number){
		return number.replaceAll("\\+","");
	}
	/**
	 * This method sum a list of string numbers. It only use BigInteger when it is necessary. Using BigInteger can be a performance penalty.
	 * @param numbers
	 * @return
	 */
	public static String sum(Collection<String>numbers){
		try{
			BigInteger bigrowresult=null;
			int rowresult=0;
			for(String number:numbers){
				number=parseString(number);
				if(bigrowresult==null){
					if(notEmpty(number)&&(!bigString(number))){
						rowresult+=Integer.parseInt(number);
					}else if(notEmpty(number)&&(!bigString(number))){
						bigrowresult=new BigInteger(rowresult+"").add(new BigInteger(number));
					}
				}
				else{
					bigrowresult=bigrowresult.add(new BigInteger(number));
				}
			}
			return bigrowresult==null?rowresult+"":bigrowresult.toString();
		}catch(Exception ex){
			//SOMETHING WENT WRONG...
			//If had a log we could print it there.
			return "E:"+ex.getMessage();
		}
	}
	/**
	 * This method multiply a list of string numbers. It only use BigInteger when it is necessary. Using BigInteger can be a performance penalty.
	 * @param numbers
	 * @return
	 */
	public static String mult(Collection<String>numbers){
		try{
			BigInteger bigrowresult=null;
			int rowresult=1;
			for(String number:numbers){
				number=parseString(number);
				if(bigrowresult==null){
					if(notEmpty(number)&&(!bigString(number))){
						rowresult*=Integer.parseInt(number);
					}else if(notEmpty(number)&&(!bigString(number))){
						bigrowresult=new BigInteger(rowresult+"").multiply(new BigInteger(number));
					}
				}
				else{
					bigrowresult=bigrowresult.multiply(new BigInteger(number));
				}
			}
			return bigrowresult==null?rowresult+"":bigrowresult.toString();
		}catch(Exception ex){
			//SOMETHING WENT WRONG...
			//If had a log we could print it there.
			return "E:"+ex.getMessage();
		}
	}
	/**
	 * This method substract a list of string numbers. It only use BigInteger when it is necessary. Using BigInteger can be a performance penalty.
	 * @param numbers
	 * @return
	 */
	public static String subtract(Collection<String>numbers){
		try{
			BigInteger bigrowresult=null;
			int rowresult=0;
			if(numbers.size()>1){
				String objRef=numbers.iterator().next();
				String number=parseString(objRef);
				if(notEmpty(number)&&(!bigString(number))){
					rowresult=Integer.parseInt(number);
				}else if(notEmpty(number)&&(!bigString(number))){
					bigrowresult=new BigInteger(number);
				}
				numbers.remove(objRef);
			}
			
			for(String number:numbers){
				number=parseString(number);
				if(bigrowresult==null){
					if(notEmpty(number)&&(!bigString(number))){
						rowresult-=Integer.parseInt(number);
					}else if(notEmpty(number)&&(!bigString(number))){
						bigrowresult=new BigInteger(rowresult+"").subtract(new BigInteger(number));
					}
				}
				else{
					bigrowresult=bigrowresult.subtract(new BigInteger(number));
				}
			}
			return bigrowresult==null?rowresult+"":bigrowresult.toString();
		}catch(Exception ex){
			//SOMETHING WENT WRONG...
			//If had a log we could print it there.
			return "E:"+ex.getMessage();
		}
	}
	
	public static boolean isPrime(int n){
		if(n==2){
			return true;
		}
		if(n%2==0){
			return false;
		}
		int sqrt=(int) Math.sqrt(n);
		for (int i = 3; i <= sqrt ; i += 2){
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int reverseNumber(int n){
		return Integer.parseInt(new StringBuffer(n+"").reverse().toString());
	}
	
	public static int nextEmirps(int n){
		while(true){
			n+=2;
			if(isPrime(n)){
				int revN=reverseNumber(n);
				if(isPrime(revN)&&revN!=n){
					return n;
				}
			}
		}
	}
}
