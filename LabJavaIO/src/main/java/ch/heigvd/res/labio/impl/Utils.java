package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    int lineEnd = 0;
    for(int i=0; i<lines.length(); ++i)
    {
      if(i<lines.length()-1 && lines.substring(i, i+2).compareTo("\r\n") == 0)
      {
        lineEnd = i+2;
        break;
      }
      else if(lines.charAt(i) == '\r' || lines.charAt(i) == '\n')
      {
        lineEnd = i+1;
        break;
      }
    }
    String firstString = lines.substring(0, lineEnd);
    String secondString = lines.substring(lineEnd);
    return new String[]{firstString, secondString};
  }

}
