package scores;
import java.util.*;
import java.io.*;
import java.net.*;



/**
*Class TestHighScore how 
*Call getScores
*ask the user for a player name
*reads all fake scores from the scoreSamples.txt
*chooses one of them at random
*Output The player name and the chosen score on the standard output
*
*@author Balandras et Naitssi
*
*/
public class TestHighScore{

	/**
	*
	*
	* @param args
	*/

	public static void main(String[] args){


		 HighScore score=new HighScore() ;
		String[]  results=score.getScores();

		System.out.println("***************************************");

		for (int j=0;j<results.length;j++){

			System.out.println(results[j]);
		}

		System.out.println("***************************************");

	     
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un nom :");	
		String name = sc.nextLine();
		FileReader monFichier = null;
      	BufferedReader tampon = null;	
        String[] scores=new String[40]; 
  try {
  File fichier = new File("scores/scoreSamples.txt"); 
  String filePath  = fichier.getAbsolutePath();	
monFichier = new FileReader(filePath);
tampon = new BufferedReader(monFichier);
int i = 0;
while (true) {

scores [i] = tampon.readLine();

if ( scores[i] == null)
break;
i++;} 
} catch (IOException exception) {
exception.printStackTrace();
} finally {
try {
tampon.close();
monFichier.close();
} catch(IOException exception1) {
exception1.printStackTrace();
}
}
      Random rand = new Random(); 
     
 System.out.println("Your scores is: "+scores[rand.nextInt(9)]); 
}	
}
