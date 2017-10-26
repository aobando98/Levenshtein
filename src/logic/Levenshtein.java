package logic;

import java.math.*;

public class Levenshtein {
	
	private String word_1;
	private String word_2;
	
	// Constructor
	public Levenshtein(String word_1, String word_2) {
		super();
		this.word_1 = word_1;
		this.word_2 = word_2;
	}
	
	// Getters and Setters
	public String getWord_1() {
		return word_1;
	}


	public void setWord_1(String word_1) {
		this.word_1 = word_1;
	}


	public String getWord_2() {
		return word_2;
	}


	public void setWord_2(String word_2) {
		this.word_2 = word_2;
	}

	
	/*
	 * Function to set the right values at the start of the analisis
	 */
	public int[][] generateMatrix(){
		int[][] result = new int[word_1.length() + 1][word_2.length() + 1];
		
		for (int i = 0; i < word_1.length() + 1; i++){
			for (int j = 0; j < word_2.length() + 1; j++){
				if (i == 0){
					result[i][j] = j;
				}else if (j == 0){
					result[i][j] = i;
				}
			}
		}
		return result;
	}
	
	/*
	 * Another function to calculate Levenshtein distance
	 * Uses Dynamic Programming
	 */
	public int distance(){
		int [][] costMatrix = generateMatrix();
		for (int i = 0; i < word_1.length(); i++){
			for (int j = 0; j < word_2.length(); j++){
				int cost = 1;
				// If the letters are the same the cost is 0 else the cost is 1
				if (word_1.charAt(i) == word_2.charAt(j)){
					cost = 0; 
				}
				costMatrix[i + 1][j + 1] = Math.min(costMatrix[i][j] + cost, Math.min(costMatrix[i][j+1] + 1, costMatrix[i+1][j] + 1));
			}
		}
		return costMatrix[word_1.length()][word_2.length()];
	}
}
