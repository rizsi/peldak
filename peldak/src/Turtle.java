import java.awt.Color;
import java.awt.Graphics2D;

public class Turtle {
	Graphics2D g;
	public double x=0;
	public double y=0;
	public double direction = 0;
	public boolean draw=false;
	
	public double size=70;
	public Turtle(Graphics2D g) {
		this.g=g;
	}
	public void forward(double length) {
		double prevx=x;
		double prevy=y;
		x+=length*Math.cos(direction);
		y+=length*Math.sin(direction);
		if(draw)
		{
			drawLine(prevx, prevy, x, y);
		}
	}
	public void drawLine(double x0, double y0, double x1, double y1)
	{
		g.drawLine(toint(size*x0), toint(-size*y0), toint(size*x1), toint(-size*y1));
	}
	private int toint(double d) {
		return (int)(d+.5);
	}
	public void setColor(Color red) {
		g.setColor(red);
	}
	public void turnLeft(double degrees) {
		direction+=Math.PI*degrees/180.0;
	}
	public double[] getPoint() {
		return new double[] {x,y,direction};
	}
	public void drawLineFrom(double[] elozo) {
		if(elozo!=null)
		{
			drawLine(elozo[0], elozo[1], x, y);
		}
	}
}
