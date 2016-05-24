package scores;
import java.util.*;
import java.io.*;

/**
		*@author Yassine Naitssi
		*@version 2
	*/
		
		
public class TestHighScore2 {




	/**
		*reads the scores from scoreSamples.txt
		*@return list a linkedlist containing the scores
	*/


		private List readScores(){

		File fichier = new File("scores/assets/scoreSamples.txt"); 

		String filePath  = fichier.getAbsolutePath();
		BufferedReader buffer = null;
		String line = "";
		String separator = ",";
		LinkedList list = new LinkedList(); 

		try {

			buffer = new BufferedReader(new FileReader(filePath));
			while ((line = buffer.readLine()) != null) {

				String[] score = line.split(separator);
				list.add(Integer.parseInt(score[0]));
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
          }

/**
          *Main Methode That:
          *Ask the user for a player name
          *Print The top ten highscores
		  *give a random score to The player
		  *Print The player name and the score given
		  *@param args unused 
	*/

	public static void main(String[] args) {

		//get player name
		TestHighScore2 test = new TestHighScore2();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez saisir un nom :");	
		String name = scanner.nextLine();

		//create HighScores2 instance
		HighScore2 scores = new HighScore2();
		String[]  results=scores.getScores();
		

		BestPlayer[] tenBest = scores.tenBestScores( results);
		
		
		System.out.println("......");

		for (int i=0;i<tenBest.length;i++){

			 

            System.out.println("   "+tenBest[i].getPlayer()+" : "+tenBest[i].getScore());
		}
		System.out.println("......");
		Random rand = new Random(); 
     String[] parts = ( results[rand.nextInt(9)]).split(",");
        System.out.println("\n"+	"      "+name+" : "+parts[0]); 

	}
}