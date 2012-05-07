package net.tuenti.contest.igbopie.tlang;

import java.util.Stack;
import java.util.Vector;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.util.Util;
/**
 * It reads tuenti language. Tuenti language is similar to Lisp(http://es.wikipedia.org/wiki/Lisp)
 * @author ignaciobonapiedrabuena
 *
 */
public class TLangCommand implements Command{

	private String line;
	public TLangCommand(String line){
		this.line=line;
	}

	@Override
	public String execute() {
		try{
			//We want to separate $ from the numbers
			String[] tokens=line.replaceAll("\\$", " \\$ ").split(" ");
			//Our useful stack
			Stack<String>stack=new Stack<String>();
			
			for(String token:tokens){
				//If is not the special token, we just push it
				if(Util.notEmpty(token)&&!token.equalsIgnoreCase("$")){
					stack.push(token);
				}else if(Util.notEmpty(token)&&token.equalsIgnoreCase("$")){
					//If it is, we execute the stack
					Vector<String>numbers=new Vector<String>();
					String operator=null;
					//We will stop when we find an operator
					while(operator==null){
						String tokenStacked=stack.pop();
						if(tokenStacked.startsWith("^")){
							operator=tokenStacked;
						}else{
							numbers.add(0,tokenStacked);
						}
					}
					String result="0";
					switch(Operator.fromString(operator)){
					case SUM:
						//This is familiar... SuperHardSum!!:D
						result=Util.sum(numbers);
						break;
					case MULT:
						result=Util.mult(numbers);
						break;
					case REST:
						result=Util.subtract(numbers);
						break;
					}
					stack.push(result);
				}
			}
			return stack.pop();
		}catch(Exception e){
			return "E:"+e;
		}
	}
	enum Operator{
		SUM("^="),
		MULT("^#"),
		REST("^@");
		private String code;
		Operator(String code){
			this.code=code;
		}
		public static Operator fromString(String text) {
			if (text != null) {
				for (Operator b : Operator.values()) {
					if (text.equalsIgnoreCase(b.code)) {
						return b;
					}
				}
			}
			return null;
		}


	}

}
