package scores;
import java.util.*;
import java.io.*;


/**
		*@author Yassine Naitssi 
		*@version 1
	*/


public class BestPlayer{

	String player=new String();
	int score;


/**
  	 * Constructor of BestPlayer class
  	 **/

	public BestPlayer(){
		
	}

	public BestPlayer(String name, int sc){

		score=sc;
		player=name;
	}

/**
  	 *@return The player score 
  	 **/
	public int getScore(){

		return score;
	}
/**
  	 *@return The player name 
  	 **/
	public String getPlayer(){

		return player;
	}
    /**
  	 *@param sc the score to set 
  	 **/
	public void setScore(int sc){

		score=sc;
	}
 /**
  	 *@param name the player name to set
  	 **/
	public void setPlayer(String name){

		player=name;
	}

/**
		*Compares the implicit player (this) to the one given in parameter by them scores
		*@param p the player we want to compare the implicit (this) player to
		*@return int compare the result of this compare
	*/

	public int compareTo(BestPlayer p){
        int compare = 0;
		if (score<p.getScore()) {compare = -1; } 
		if (score>p.getScore()) {compare =  1; } 
		return compare;

	}




}