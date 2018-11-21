import java.awt.*;
import java.applet.*;
import java.awt.Font;
import java.util.Date;
import java.lang.*;

public class DigitalClock extends Applet implements Runnable {
    
    Color textColor;              // the color of the DigitalClock text
    Color bgColor;                // the color of the DigitalClock background
    int   appletHeight;           // the height of the applet
    int   appletWidth;            // the width of the applet
    String fontName;              // the name of the font to use (Courier, etc.)
    int    fontStyle;             // the font style (PLAIN, BOLD, ITALIC)
    int    fontSize;              // the font size (10, 12, 14, etc.)
    
    Image  offScreenImage;        // double-buffering variable
    Graphics offScreenGraphics;   // double-buffering variable
    String date;                  // the 'date' string (printed on screen)
    String time;                  // the 'time' string (printed on screen)
    int xDate;                    // the x-coordinate for the date string
    int yDate;                    // the y-coordinate for the date string
    int xTime;                    // the x-coordinate for the time string
    int yTime;                    // the y-coordinate for the time string
    
    Font theFont;
    Thread runner;
    
    String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] days   = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    String[] nums = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                      "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                      "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
                      "30", "31", "32", "33", "34", "35", "36", "37", "38", "39",
                      "40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
                      "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };
    

    //-------------------------[  getDateString()  ]-------------------------//
    
    public String getDateString () {
        Date theDate    = new Date();
        String dayOfWeek  = days[theDate.getDay()];
        String month      = months[theDate.getMonth()];
        String dayOfMonth = nums[theDate.getDate()];
        String newDate = dayOfWeek + " " + month + " " + dayOfMonth;
        return(newDate);
    }
    

    //-------------------------[  getTimeString()  ]-------------------------//
    
    public String getTimeString () {
        Date theDate = new Date();
        String hh      = nums[theDate.getHours()];
        String mm      = nums[theDate.getMinutes()];
        String ss      = nums[theDate.getSeconds()];
        String newTime = hh + ":" + mm + ":" + ss;
        return(newTime);
    }


    //-------------------------[  getTimeString()  ]-------------------------//
    /*
     * override the default version of 'update' to help reduce flicker
     *
     */
    
    public void update (Graphics g) {
        paint(g);
    }
    
    
    //-------------------------[  paint()  ]-------------------------//
   
    public void paint(Graphics g) {

        // to reduce flicker, draw the old date in the bgColor color
        
        offScreenGraphics.setColor(bgColor);
        offScreenGraphics.setFont(theFont);
        offScreenGraphics.drawString(date, xDate, yDate);
        offScreenGraphics.drawString(time, xTime, yTime);

        // now draw all the new info to offScreenGraphics in the textColor

        offScreenGraphics.setColor(textColor);
        offScreenGraphics.setFont(theFont);

        // determine the x/y location of the Date string
        int stringHeight = getStringHeight(this, theFont);

        date = getDateString();
        time = getTimeString();
        
        xDate = getXLoc (this, date, theFont);
        yDate = getYLocDate (this, theFont);

        // determine the x/y location of the Time string
        xTime = getXLoc(this, time, theFont);
        yTime = yDate + stringHeight;

        offScreenGraphics.drawString(date, xDate, yDate);
        offScreenGraphics.drawString(time, xTime, yTime);
        
        // draw the new image all at once to 'g'
        
        g.drawImage(offScreenImage, 0, 0, this);
    }
    

    //-------------------------[  start()  ]-------------------------//
    
    public void start() {
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }
    

    //-------------------------[  stop()  ]-------------------------//
    
    public void stop() {
        if (runner != null) {
            runner.stop();
            runner = null;
        }
    }
    

    //-------------------------[  run()  ]-------------------------//
    
    public void run() {
        while (true) {
            repaint();
            try { Thread.sleep(1000); }
            catch (InterruptedException e) {}
        }
    }


    //-------------------------[  init()  ]-------------------------//
    
	public void init() {
		super.init();
		
	    // read in the HTML <param> fields
	    
		bgColor       = GetAppletParameter.toColor(this,  "BG_COLOR",   Color.white);
		textColor     = GetAppletParameter.toColor(this,  "TEXT_COLOR", Color.black);
		fontName      = GetAppletParameter.toString(this, "FONT_NAME",  "Helvetica");
		fontStyle     = GetAppletParameter.toInt(this,    "FONT_STYLE", Font.PLAIN);
		fontSize      = GetAppletParameter.toInt(this,    "FONT_SIZE",  16);
		appletHeight  = GetAppletParameter.toInt(this,    "HEIGHT",   100);
		appletWidth   = GetAppletParameter.toInt(this,    "WIDTH",    200);
		
        theFont = new Font(fontName, fontStyle, fontSize);
        
		setLayout(null);
		addNotify();
		resize(appletWidth, appletHeight);
		setBackground(bgColor);

        // initialize a few values for double-buffering (reduce flicker)
        
        xDate = yDate = xTime = yTime = 0;
        date = time = "";
        offScreenImage    = createImage(appletWidth, appletHeight);
        offScreenGraphics = offScreenImage.getGraphics();

	}
	
	
	//---------------------------------------------------------------------//
	// getXLoc() - determine the X-location of a String so the String is   //
	//             properly centered on-screen.                            //
	//---------------------------------------------------------------------//

	public int getXLoc (Applet a, String s, Font f) {
	    FontMetrics fontMetrics = a.getFontMetrics(f);
	    int stringWidth = fontMetrics.stringWidth(s);

	    // next - assume (!) appletWidth > stringWidth
	    int extraPixelsOnSides = appletWidth - stringWidth;
	    int pixelsOnLeft = extraPixelsOnSides / 2;
	    return(pixelsOnLeft);
	}


    //-------------------------[  getYLocDate()  ]-------------------------//
    //  Determine the proper y-location for the Date String (i.e., the     //
    //  String that is printed on the top, above the Time).                //
	//---------------------------------------------------------------------//
    
	public int getYLocDate (Applet a, Font f) {
	    FontMetrics fm   = a.getFontMetrics(f);
	    int normalHeight = fm.getHeight();
	    int maxAscent    = fm.getMaxAscent();
	    int extraPixelsTopBtm = appletHeight - (2*normalHeight);
	    return((extraPixelsTopBtm/2) + maxAscent);
	}


    //-------------------------[  getStringHeight()  ]-------------------------//
    
	public int getStringHeight (Applet a, Font f) {
	    FontMetrics fontMetrics = a.getFontMetrics(f);
	    return(fontMetrics.getHeight());
	}


    //-------------------------[  handleEvent()  ]-------------------------//
    
	public boolean handleEvent(Event event) {
		return super.handleEvent(event);
	}

}
