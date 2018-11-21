//Java code for Calculator Applet


import java.awt.*;
import java.lang.*;
import java.applet.Applet;


public class Calculator extends java.applet.Applet
{
    //members;
    TextField  text;
    String   s,s1, s2;
    double   d1, d2, d3;    
    boolean  b;
    
    public Calculator()  //constructor
    {
        Panel pFrame = new Panel();
        pFrame.setLayout(new FlowLayout());

        text = new TextField("");
        text.setForeground(Color.blue);
        text.setEditable(true); //display part

        Panel pCalc = new Panel();
        pCalc.setLayout(new BorderLayout(0, 10));
        pCalc.add("North", text);

        pFrame.add("Center", pCalc);

        Dimension dSize= pCalc.size();
        dSize.width = dSize.width + 50;
        dSize.height = dSize.height + 50;
        pFrame.resize(dSize);

        Panel pKey = new Panel();
        pKey.setLayout(new GridLayout(5, 5, 5, 5));
        add("Center", pKey);
        pKey.add(new Button("C"));
        pKey.add(new Button("7"));
        pKey.add(new Button("8"));
        pKey.add(new Button("9"));
        pKey.add(new Button("/"));
        pKey.add(new Button("4"));
        pKey.add(new Button("5"));
        pKey.add(new Button("6"));
        pKey.add(new Button("*"));
        pKey.add(new Button("1"));
        pKey.add(new Button("2"));
        pKey.add(new Button("3"));
        pKey.add(new Button("-"));
        pKey.add(new Button("0"));
        pKey.add(new Button("."));
        pKey.add(new Button("="));
        pKey.add(new Button("+"));
        pKey.add(new Button("%"));

        pCalc.add("East", pKey);

        setLayout(new BorderLayout(0, 0));
        add("North", pFrame);
        setBackground(Color.blue);

        d1 = 0.0d;
        d2 = 0.0d;
        d3 = 0.0d;
        s = "";
        text.setText("0");
        b = true;
    }
   
    public boolean action(Event evt, Object arg) //event handler
    {
        
        if ("C".equals(arg))//numeric key output cancel all
        {
            d1 = 0.0d;
            d2 = 0.0d;
            s = "";
            text.setText("0");
            b = true;
        }
        else if (("0".equals(arg))  ||("1".equals(arg)) || ("2".equals(arg))
               || ("3".equals(arg)) || ("4".equals(arg)) || ("5".equals(arg))
               || ("6".equals(arg)) || ("7".equals(arg)) || ("8".equals(arg))
               || ("9".equals(arg)) || (".".equals(arg)))
        {
            if (b)
                s2 = (String) arg;
            else
                s2 = text.getText() + arg;
            text.setText(s2);
            b = false;
        }
        
        else if (("+".equals(arg)) || ("-".equals(arg)) //operations
               || ("*".equals(arg)) || ("/".equals(arg)) || ("=".equals(arg)) || ("%".equals(arg)))
        {
            s1 = text.getText();
            d2 = (Double.valueOf(s1)).doubleValue();
            d1 = Calculation(s, d1, d2);
            Double dTemp = new Double(d1);
            s2 = dTemp.toString();
            text.setText(s2);
            s = (String) arg;
            b = true;
        }
        return true;
    }
    //calculations
    private double Calculation(String s, double d1, double d2) //calculates the value and returns to the display
    {
        if ("+".equals(s)) 
        	d1 = d1 + d2;
        else if ("-".equals(s)) 
        	d1 = d1 - d2;
        else if ("*".equals(s)) 
        	d1 = d1 * d2;
        else if ("/".equals(s)) 
        	d1 = d1 / d2;
        else if ("%".equals(s)) 
        	d1 = d1 % d2;	
        else
        	 d1 = d2;
        return d1;
    }
}