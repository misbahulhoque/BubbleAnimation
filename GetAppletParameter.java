import java.applet.Applet;
import java.awt.Color;

/**
 *  The GetParameter class is used to retrieve parameters that are pass to
 *  applets via the <param> tag in an HTML document.
 *
 *  @version 1.0 (alpha)
 *  @author  DevDaily Interactive, Inc.
 *
*/
public class GetAppletParameter {

   //----------------------------------------------//
   //  Methods implemented in this class:          //
   //  ----------------------------------          //
   //      toString()                              //
   //      toColor()                               //
   //      toInt()                                 //
   //----------------------------------------------//

   //------------------------[  toColor()  ]-------------------------------//
   /**
    *  Converts an applet input parameter to a Color object
    *  @return  A Color object
    *  @param   paramName A String containing the name of the parameter to retrieve.
    *  @param   defaultColor A Color object containing the default color that should be
                used in case the parameter is not supplied or the conversion fails.
   */

   public static Color toColor (Applet applet, String paramName, Color defaultColor) {

      Color color;

      String s = applet.getParameter(paramName);

      if (s == null)
         // if the parameter was not supplied, just return the defaultColor
         return defaultColor;

      else {

         try {

            // string should begin with '#' character (something like #996666)
            if (s.charAt(0) == '#') {
               char chars[];
               chars = new char[s.length()];
               s.getChars(0,s.length(), chars, 0);
               color = new Color(Integer.parseInt(new String(chars, 1, s.length()-1), 16));
               //return (new Color(Integer.parseInt(new String(chars, 1, s.length()-1), 16)));
               return (color);

            } else {
                color = new Color(Integer.parseInt(s,16));
                return (color);
            }

         } catch (NumberFormatException nfe) {
            System.out.println("Invalid color specification: " + nfe.getMessage());
            return null;
         } // end try-catch

      } // end if-else

   }  // end toColor()



   //------------------------[  toString()  ]-------------------------------//
   /**
    *  A convenience method, returns the value of a String parameter
    *  @return  A String object
    *  @param   paramName A String containing the name of the parameter to retrieve.
    *  @param   defaultString A String to use in case it was not supplied in the HTML code.
   */

   public static String toString(Applet applet, String paramName, String defaultString) {

      String theParam = applet.getParameter(paramName);

      if (theParam == null)
         // if the parameter was not supplied, just return the defaultString
         return defaultString;
      else {
        return(theParam);

      }  // end if-else

   } // end toString()



   //------------------------[  toInt()  ]-------------------------------//
   /**
    *  Converts an applet parameter to an int value.
    *  @return  An int
    *  @param   paramName  A String containing the name of the parameter to retrieve.
    *  @param   defaultInt An int to use as a default in case the parameter is not supplied.
   */

   public static int toInt(Applet applet, String paramName, int defaultInt) {

      String theParam = applet.getParameter(paramName);

      if (theParam == null)
         return defaultInt;    // if parameter not supplied, just return defaultInt
      else {
        return(Integer.parseInt(theParam));
      }

   }


} 