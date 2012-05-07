package net.tuenti.contest.igbopie.therobot.model.entity;

import java.util.List;
import java.util.Vector;

public class Canvas {
	private int bgColor=1;
	private int width;
	private int height;
	private List<Rectangle>objects;//MMM... decorator pattern... NOTIME!!
	
	public Canvas(int bgColor, int width, int height) {
		super();
		this.bgColor = bgColor;
		this.width = width;
		this.height = height;
		objects=new Vector<Rectangle>();
	}
	
	public int getBgColor() {
		return bgColor;
	}
	public void setBgColor(int bgColor) {
		this.bgColor = bgColor;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void addRectangle(Rectangle rectangle){
		this.objects.add(rectangle);
	}
	public String paint(){
		StringBuffer paint=new StringBuffer();
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				int pixelColor=this.bgColor;
				for(Rectangle rec:objects){
					if(rec.isInSpot(j, i)){
						pixelColor=rec.getColor();
					}
				}
				if(pixelColor>=10){
					paint.append((char)(pixelColor-10+'a'));
				}else{
					paint.append(pixelColor);
				}
			}
			paint.append("\n");
		}
		return paint.toString();
		
		
	}
	
}
