package homework;

import java.util.Arrays;
import java.util.Random;

public class test {

	public static void main(String[] args) {
		  Random rand = new Random();
		  int[] randArray = new int[10];
		  for (int i = 0; i < randArray.length; i++) {
			randArray[i] = rand.nextInt(10)+1;
		}
          ArrayHandler testArray = new ArrayHandler();
          System.out.println(testArray.toString());
		  System.out.println(Arrays.toString(randArray));
          System.out.println(testArray.isBalanced(5));
          System.out.println(Arrays.toString(testArray.getDuplicates()));
          System.out.println(testArray.howManyIn(randArray));
	}

}
