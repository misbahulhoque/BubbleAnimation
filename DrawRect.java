import java.awt.*;
import javax.swing.*;
import java.applet.*;

public class DrawRect extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.orange);
		g.fillRect(20,50,100,100);
	}
}