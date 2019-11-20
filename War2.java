package thisIsWar;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class War2 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		String playerOne = input.nextLine();
		String playerTwo = input.nextLine();
		int[] p1Cards = new int[28];
		int[] p2Cards = new int[28];
		//Creating Deck
		int[][] cards = new int[4][14];
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				cards[i][j] = rand.nextInt(15);
			}
		}
		for (int i = 0; i < cards.length; i++) {
			System.out.println("Original ");
			System.out.println(Arrays.toString(cards[i]));
		}
		//Shuffling Deck
		int[] shuffled = new int[56];
        int counter = 0;
        for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				shuffled[counter] = cards[i][j];
				counter++;
			}
		}
        System.out.println("One Layer Deck ");
        System.out.println(Arrays.toString(shuffled));
        int index, temp;
        for (int i = 0; i < shuffled.length; i++) {
			index = rand.nextInt(shuffled.length);
			temp = shuffled[index];
			shuffled[index] = shuffled[i];
			shuffled[i] = temp;
		}
        System.out.println("Completed Shuffled Deck");
        System.out.println(Arrays.toString(shuffled));
        //Dealing the cards
        for (int i = 0; i < shuffled.length; i++) {
			if(i%2 == 0) {
				p1Cards[i/2] = shuffled[i];
			}
			else {
				p2Cards[i/2] = shuffled[i];
			}
		}
        System.out.println(Arrays.toString(p1Cards));
        System.out.println(Arrays.toString(p2Cards));
        //The Game
        int p1Points = 0;
        int p2Points = 0;
        for (int i = 0; i < p1Cards.length; i++) {
			if(p1Cards[i] > p2Cards[i]) {
				p1Points++;
			}
			else if(p2Cards[i] > p1Cards[i]) {
				p2Points++;
			}
			else {
				int tieBreaker = 2;
				while(i+tieBreaker < 28 && (p1Cards[i+tieBreaker] == p2Cards[i+tieBreaker])) {
					tieBreaker += 2;
			    }
				while(i+tieBreaker > 28) {
					tieBreaker--;
				}
				if(p1Cards[i+tieBreaker] > p2Cards[i+tieBreaker]) {
					System.out.println();
					System.out.printf("%s won this tie", playerOne);
					p1Points++;
				}
				else if(p2Cards[i+tieBreaker] > p1Cards[i+tieBreaker]) {
					System.out.println();
					System.out.printf("%s won this tie", playerTwo);
					p2Points++;
				}
				else {
					p1Points++;
					p2Points++;
				}
		}
        
	  }
        if(p1Points > p2Points) {
        	System.out.println();
        	System.out.printf("%s won the game with %d points", playerOne, p1Points);
        }
        else if(p2Points > p1Points) {
        	System.out.println();
        	System.out.printf("%s won the game with %d points", playerTwo, p2Points);
        }
        else {
        	System.out.println();
        	System.out.println("Nobody wone :(");
        }
	}
}
