package net.tuenti.contest.igbopie.therobot;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

import net.tuenti.contest.igbopie.services.Command;
import net.tuenti.contest.igbopie.therobot.model.entity.Canvas;
import net.tuenti.contest.igbopie.therobot.model.entity.Rectangle;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class TheRobotCommand implements Command{
	private String line;

	public TheRobotCommand(String line){
		this.line=line;
	}
	
	@Override
	public String execute() {
		try{
			line=line.trim();
			int width = 0;
			int height = 0;
			int nRectangles;
			int i=0;
			int rectI=0;
			Canvas canvas = null;
			Rectangle rectangle =new Rectangle();
			for(String token:line.split(" ")){
				if(token!=null&&!token.equalsIgnoreCase("")){
					switch(i){
					case 0:
						width=Integer.parseInt(token);
						break;
					case 1:
						height=Integer.parseInt(token);
						break;
					case 2:
						nRectangles=Integer.parseInt(token);
						canvas=new Canvas(1, width, height);
						break;
					default:
						switch(rectI){
						case 0:
							rectangle.setXi(Integer.parseInt(token));
							break;
						case 1:
							rectangle.setYi(Integer.parseInt(token));
							break;
						case 2:
							rectangle.setXf(Integer.parseInt(token));
							break;
						case 3:
							rectangle.setYf(Integer.parseInt(token));
							break;
						case 4:
							rectangle.setColor(Integer.parseInt(token));
							canvas.addRectangle(rectangle);
							rectangle =new Rectangle();
							rectI=-1;
							break;
						}
						rectI++;
					}
					
					i++;
				}
			}
			HashMap<Character,Integer>histogram=new HashMap<Character, Integer>();
			String result=canvas.paint();
			for(int index=0;index<result.length();index++){
				char c=result.charAt(index);
				if(c!='\n'){
					Integer num=histogram.get(c);
					if(num==null){
						num=0;
					}
					num++;
					histogram.put(c, num);
				}
			}
			List<String>lista=new Vector<String>();
			for(Entry<Character,Integer>entry:histogram.entrySet()){
				Character c=entry.getKey();
				String cString="0"+c+"";
				if(c>='a'){
					cString=((int)c-'a'+10)+"";
				}
				lista.add(cString+" "+entry.getValue());
			}
			Collections.sort(lista);
			return lista.toString().replaceAll("[\\[\\],]", "").replaceAll("0(\\d)", "$1");
		
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
