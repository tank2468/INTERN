import java.util.List;
import java.util.Scanner;

public class testing {


public static void main (String[] args){
	
	System.out.println("Please enter integers to be checked if any of the paired value adds up to 10 (separate it by commas)");
	
	Scanner input = new Scanner (System.in);
	
	String line = input.nextLine(); //Reading the next line of the inputs
	String [] div = line.split(","); //splitting the string inputs by commas
	int [] listofNumbers = new int[div.length]; //Creating an array with size of the given input
	
	for(int k = 0; k <div.length; k++){ //Storing elements into the array that was created
		listofNumbers[k] = Integer.parseInt(div[k]);
		
	}
	input.close();
	
	String answerDigit = ""; 
	int sizeCounter = 0;
	
		while (sizeCounter != div.length){
			
		String biggestDigit = Result(listofNumbers);
		answerDigit = answerDigit + biggestDigit;
		sizeCounter++;
		
		
		}
		
		
		
		
		
		System.out.println(answerDigit);
		
		
}
	public static String Result(int [] numbers){
	
		
			String output = ""; //Creating an array to store the results to be returned at the end
			 //Counter for storing correct pairs to be returned
			
			int temp = 0;
			//int counter = 0;
			for (int i=0; i < numbers.length; i++){ //Loop that checks all the elements in the created array
				
				
				int j = numbers.length - 1; //Start checking from the first element of the array with last element of the array
				
				
				while (i < j){
					
					int firstNumfirstDigit = Integer.parseInt(Integer.toString(numbers[i]).substring(0, 1)); //single digit of first input
					int secondNumfirstDigit = Integer.parseInt(Integer.toString(numbers[j]).substring(0, 1)); //single digit of last input
					
					
						if((firstNumfirstDigit == secondNumfirstDigit) && (firstNumfirstDigit != 0) && (secondNumfirstDigit !=0)){
							checkingSameNum(firstNumfirstDigit, secondNumfirstDigit, temp);
							
							//Call/create a function that would compare numbers[i] and numbers[j] 
							if(firstNumfirstDigit > secondNumfirstDigit){
								temp = numbers[i];
							}
							else{
								temp = numbers[j];
								
							}
							
						}
							else{
								if(firstNumfirstDigit > secondNumfirstDigit){
									
									int checkingNum = Integer.parseInt(Integer.toString(temp).substring(0, 1));
									if(checkingNum > firstNumfirstDigit){
									break;
									}
							
								}
								else{
									int checkingNum = Integer.parseInt(Integer.toString(temp).substring(0, 1));
									if(secondNumfirstDigit > checkingNum){
										temp = numbers[j];
									}
									
									else{
									//	Integer.toString(temp);
									//	output = output + temp;
									j--;
										
									}
								}
					
							j--;
					
					}
					
			}
				
				
			}
			
			removeNumber(numbers,temp);
			Integer.toString(temp);
			output = output + temp;
			
			
			
			return output;
			
				
	}
	
	public static int[] removeNumber (int [] listofNumbers, int biggestNum){
		
		for(int k = 0; k <listofNumbers.length; k++){ //Storing elements into the array that was created
			if(listofNumbers[k] == biggestNum){
				listofNumbers[k] = 0;
				
			}
			else{
				
				
			}
		}
		return listofNumbers;
		
		
	}
	
	public static int checkingSameNum(int firstNum, int secondNum, int tempstore){
		if(firstNum > secondNum){
			tempstore = firstNum;
			
		}
		else{
			tempstore = secondNum;
			
		}
		return tempstore;
		
	}
	
	
	
	}
	
	
	




