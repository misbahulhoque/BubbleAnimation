import java.awt.*;
import javax.swing.*;

class DrawImage extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Image image=new ImageIcon("MisbahParkiMod (Small).jpg").getImage();
		g.drawImage(image,3,4,this);
	}
}