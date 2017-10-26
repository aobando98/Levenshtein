package logic;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Levenshtein distance Calculator");
		
		while(true){
			System.out.println("1. Calculate new distance");
			System.out.println("2. Exit");
			Scanner operacion_in = new Scanner(System.in);
		    String operacion = operacion_in.nextLine();
		    
		    if ("1".compareTo(operacion) == 0){ // New distance
		    	Scanner word_1 = new Scanner(System.in);
			    System.out.println("Please insert the first word: ");
			    String string_1 = word_1.nextLine();
			    Scanner word_2 = new Scanner(System.in);
			    System.out.println("Please insert the second word: ");
			    String string_2 = word_2.nextLine();
			    
			    Levenshtein calculation = new Levenshtein(string_1, string_2);
			    System.out.print("Distance = ");
			    System.out.println(calculation.distance());
			    
		    }else if ("2".compareTo(operacion) == 0){ //despliega texto
		    	break;
		    }
		}
	}
}
