import java.awt.*;
import java.applet.*;

public class DrawOval extends Applet
{
	public void paint(Graphics g)
	{
		try{
		g.drawOval(20,20,200,200);
		g.setColor(Color.green);
		g.fillOval(71,71,100,100);
		}
		catch (Exception ex){}
	}
}