package scores;
import java.util.*;
import java.io.*;
import java.net.*;


/** 
*@author Balandras et Naitssi
*@version 1
*/
public class HighScore{

	/**
  	 * The Constructor of the HighScore
  	 **/

  	public void HighScore() {	
	}

	/**
	 *Return all scores  in  feed.csv of our channel 
	 *@return an ArrayList containing all scores in our channel 
	 */

	 public static String [] getScores(){


		ArrayList tmp = new ArrayList();
		
		int i = 0;
	    try {

			URL url = new URL("https://thingspeak.com/channels/110673/feed.csv");
			URLConnection connection = url.openConnection();
			InputStreamReader inStream = new InputStreamReader(connection.getInputStream());
			BufferedReader buff = new BufferedReader(inStream);
			String entete = buff.readLine();

			String line ;
		
				            		
			while ((line= buff.readLine())  != null) {
			

				String[] parts = line.split(",");
				if (parts.length>2) tmp.add(parts[2])  ;
				i++;

			} 
				
			inStream.close();
		}
		catch (Exception e) { e.printStackTrace(); }
		String [] scores = new String[tmp.size()];
		for (int j=0; j<tmp.size() ; j++)
		{
			scores [j]  = (String) tmp.get(j);
		} 
		return scores ;
	}
}