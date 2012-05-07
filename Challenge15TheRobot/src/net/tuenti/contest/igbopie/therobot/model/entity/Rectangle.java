package net.tuenti.contest.igbopie.therobot.model.entity;

public class Rectangle {
	private int xi;
	private int yi;
	
	private int xf;
	private int yf;
	
	private int color;
	public Rectangle(){};
	public Rectangle(int xi, int yi, int xf, int yf, int color) {
		super();
		this.xi = xi;
		this.yi = yi;
		this.xf = xf;
		this.yf = yf;
		this.color = color;
	}

	public boolean isInSpot(int x,int y){
		 return (xf>x&&xi<=x&&yf>y&&yi<=y)||(xf<x&&xi>=x&&yf<y&&yi>=y);
	}
	public int getXi() {
		return xi;
	}

	public void setXi(int xi) {
		this.xi = xi;
	}

	public int getYi() {
		return yi;
	}

	public void setYi(int yi) {
		this.yi = yi;
	}

	public int getXf() {
		return xf;
	}

	public void setXf(int xf) {
		this.xf = xf;
	}

	public int getYf() {
		return yf;
	}

	public void setYf(int yf) {
		this.yf = yf;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
