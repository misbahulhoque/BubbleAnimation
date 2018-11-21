import java.awt.*;
import java.applet.*;

public class Triangle extends Applet
{
	public void paint(Graphics g)
	{
		try{
		g.drawLine(10,20,170,40);		
		g.drawLine(170,40,80,140);
		g.drawLine(80,140,10,20);
		}catch (Exception ex){}
	}
}