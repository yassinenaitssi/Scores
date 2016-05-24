package scores;
import java.util.*;
import java.io.*;


		/**
		*@author Yassine Naitssi
		*@version 3
	*/
		
public class TestHighScore3 {




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
		  *Send the score given and the player name if his score is among the top 10
		  *@param args unused 
	*/

	public static void main(String[] args) {

	
		TestHighScore3 test = new TestHighScore3();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez saisir un nom :");	
		String name = scanner.nextLine();

		
		HighScore3 scores = new HighScore3();
		String[]  results=scores.getScores();
		

		BestPlayer[] tenBest = scores.tenBestScores(results);
		
		
		System.out.println("######################");

		for (int i=0;i<tenBest.length;i++){

			String[] parts = ( results[i]).split(",");          			
            System.out.println("   "+tenBest[i].getPlayer()+" : "+tenBest[i].getScore());
		}
		System.out.println("######################");
		Random rand = new Random(); 
		int score = (int)test.readScores().get(rand.nextInt(test.readScores().size()));
     
        System.out.println("\n"+	"      "+name+" : "+score);
        

		for (BestPlayer p : tenBest)
        	{
            		if (p.getScore() < score)
            		{
                		scores.sendScore(new BestPlayer(name,score));
                		break;
            		}
        	}

	}
}