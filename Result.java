import java.util.Scanner;

public class Main {

	
public static void main (String[] args){
	
		Result();
	
	
}

	public static int[] Result(){
	
	
		System.out.println("Please enter integers to be checked if any of the paired value adds up to 10 (separate it by commas)");
	
		Scanner input = new Scanner (System.in);
		
		String line = input.nextLine(); //Reading the next line of the inputs
		String [] div = line.split(","); //splitting the string inputs by commas
		int [] numbers = new int[div.length]; //Creating an array with size of the given input
		
		for(int k = 0; k <div.length; k++){ //Storing elements into the array that was created
			numbers[k] = Integer.parseInt(div[k]);
			
		}
			int [] output = new int [numbers.length]; //Creating an array to store the results to be returned at the end
			int counter=0; //Counter for storing correct pairs to be returned
			
			for (int i=0; i < numbers.length; i++){ //Loop that checks all the elements in the created array
			
				int j = numbers.length - 1; //Start checking from the first element of the array with last element of the array
				while( i < j){
					int addedValue = numbers[i] + numbers[j]; //Add two i th and j th elements
					
					if (addedValue == 10){ //Compare to see if added integer is equal to ten; if so print out the pair
						System.out.format("(%d,%d)", numbers[i], numbers[j]);
						output[counter]=numbers[i]; //Storing first and second element to be paired up in the first index and second index of output array and reset the new counter index for the next values by 2
						output[counter+1]=numbers[j];
						counter=counter+2;	
							j--;
					} 		
					
						else { //If the two pair do not add up to ten, check the value at loction of j-1
							j--;
						}
				}
						
			}
					
			input.close();
			return output;
					
				
				
	}		
}



	
