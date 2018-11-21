import java.awt.*;
import java.applet.*;

public class Hellojava extends Applet
{
	public void paint(Graphics g)
	{
		try
		{
		g.setColor(Color.BLACK);
		g.drawString("Misbah Ul Hoque",0,200);
		g.drawLine(10,10,40,40);
		g.drawRect(10,60,40,30);
		g.drawRoundRect(10,100,80,50,10,10);
		g.setColor(Color.green);
		g.fillRect(60,10,30,80);
		g.fillRoundRect(20,110,60,30,5,5);
		g.setColor(Color.BLACK);
		g.drawLine(100,10,230,140);
		g.drawLine(100,140,230,10);
		}
		catch (Exception ex){}
	}
}