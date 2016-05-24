package scores;
import java.util.*;
import java.net.*;
import java.io.*;
import scores.*;


/**
		*@author Yassine Naitssi
		*@version 4
	*/


public class HighScore4 {
 
/**
  	 * Constructor of HighScore class
  	 **/
  	public void HighScore4() {	
	}
	
	/**
		*Get all the scores from the file feed.csv of the channel
		*@return a String Array containing all the lines 
	*/
	

	public String[] getScores(){

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
				if (parts.length>2) {tmp.add(parts[2]+","+parts[3]);}  ;
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

/**
		*Give The ten BestPlayers from the String array gived  in parameter
		*@param readScores String array containing the lines read from the feed.csv of the channel
		*@return bestPlayer containing the top ten players of the String array gived in parameter 
	*/
	public BestPlayer[] tenBestScores(String [] readScores){

		BestPlayer[] allBest= new BestPlayer[readScores.length];

		for(int i=0;i<readScores.length;i++){
			String[] parts = ((String)readScores[i]).split(",");
			allBest[i]=new BestPlayer();
			allBest[i].setPlayer(parts[1]);
			allBest[i].setScore(Integer.parseInt(parts[0]));
		}

		int i=0;
		int j=0;
		List<BestPlayer> resultList = new ArrayList<BestPlayer>();
		BestPlayer best;

		while((i<allBest.length) && (i<10)){
			
			best= allBest[0];

			for(j=0;j<allBest.length;j++){
				
				if((allBest[j].compareTo(best)>=0)&& !(resultList.contains(allBest[j]))){

					best=allBest[j];
				}
			}

			resultList.add(best);
			i++;

		}


         BestPlayer[] bestPlayer = resultList.toArray(new BestPlayer[1]);
		return  bestPlayer;
	}

	/**
        *Modify my ThingSpeak channel about a player and his score
		*@param p The BestPlayer that we want to send on the ThingSpeak channel
	*/
    	public void sendScore(BestPlayer p){
        	try {
        
            	String nom = p.getPlayer();
            	int score = p.getScore();
            	URL getURL = new URL("https://api.thingspeak.com/update?api_key=L3NCY52B93ZXFTFU&field1="+score+ "&field2="+nom);
            	getURL.openStream();
            
        	} catch (Exception e) { e.printStackTrace(); }
    	}


}