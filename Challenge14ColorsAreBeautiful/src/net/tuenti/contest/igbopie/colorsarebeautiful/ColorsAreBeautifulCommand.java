package net.tuenti.contest.igbopie.colorsarebeautiful;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.tuenti.contest.igbopie.services.Command;
/**
 * @author ignaciobonapiedrabuena
 *
 */
public class ColorsAreBeautifulCommand implements Command{
	private String line;
	private String imageFile;

	public ColorsAreBeautifulCommand(String image,String line){
		this.line=line;
		this.imageFile=image;
	}
	
	@Override
	public String execute() {
		try{
			line=line.trim();
			char colorChoose=line.charAt(0);
			int nline=Integer.parseInt(line.substring(1));
			
			BufferedImage image=ImageIO.read(new File(imageFile));
			
			int value=1;//+1
			
			for(int i=0;i<image.getWidth();i++){
				int color=image.getRGB(i, nline);
				// No need for alpha now
				//int alpha = (color >> 24) & 0xff;
				switch(colorChoose){
				case 'R':
					//SHIFT and MASK
					value+= (color >> 16) & 0xff;
					break;
				case 'G':
					value+= (color >> 8) & 0xff;
					break;
				case 'B':
					value+= (color) & 0xff;
				}
				
			}
			return ""+value;
		
		}catch(Exception e){
			return "E:"+e;
		}
	}

}
