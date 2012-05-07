package net.tuenti.contest.igbopie.superhardsum.util;

import java.math.BigInteger;
/**
 * This is a util class with some useful methods.
 * @author ignaciobonapiedrabuena
 *
 */
public class SuperHardSumUtil {
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
	public static String sum(String[]numbers){
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

}
