package homework;

import java.util.Arrays;
import java.util.Random;

public class ArrayHandler {
      public int[] array;
      
      
      //constructors
      Random rand = new Random();
	public ArrayHandler(int[] array) {
		this.array = array;
	}

	public ArrayHandler() {
	    this.array = new int[10];
		for (int i = 0; i < 10; i++) {
			this.array[i] = rand.nextInt(10)+1;
		}
	}
	
	
	
	
	
    //toString
	@Override
	public String toString() {
		return String.format(Arrays.toString(array));
	}
	
	
	
	//Actions
	//isBalanced
	public boolean isBalanced(int index) {
		int firstSum = 0;
		int secondSum = 0;
		for (int i = 0; i < index; i++) {
			firstSum += this.array[i];
		}
		for (int i = index; i < array.length; i++) {
			secondSum = this.array[i];
		}
		return (firstSum == secondSum);
	}
	
	
	
	
	//getDuplicates
	public int[] getDuplicates() {
	int[] temp = this.array.clone();
	int[] temp2 = this.array.clone();
	int counter = 0;
	for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < array.length; j++) {
			if(temp[i] == temp[j] && i != j && temp[i] != -1) {
				counter++;
				temp[j] = -1;
			}
		}
		
	}
	int[] getDup = new int[counter];
	counter = 0;
	for (int i = 0; i < temp2.length; i++) {
		for (int j = 0; j < temp2.length; j++) {
			if(temp2[i] == temp2[j] && i != j && temp2[i] != -1) {
				getDup[counter] = temp2[j];
				counter++;
				temp2[j] = -1;
			}
		}
		temp2[i] = -1;
	}
	return getDup;
		
	}
	
	
	
	//howManyIn
	public int howManyIn(int[] newArray) {
		int counter = 0;
		boolean same = false;
		int[] temp = this.array.clone();
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if(newArray[i] == temp[j]) {
					temp[j] = -1;
					same = true;
					continue;
				}
			}
			if(same) {
				counter++;
			}
			same = false;
		}
		return counter;
	}
	
      
}
