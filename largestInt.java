

import java.util.Scanner;

public class largestInt {


public static void main (String[] args){
    
	System.out.println("Please enter integers to be checked if any of the paired value adds up to 10 (separate it by commas)");
    
	Scanner input = new Scanner (System.in);
    
	String line = input.nextLine(); //Reading the next line of the inputs
	
	while (line.equals("")){
		System.out.println("Please re-enter integers to be checked if any of the paired value adds up to 10 (separate it by commas)");
		line = input.nextLine(); //Reading the next line of the inputs
	}
	
	String [] div = line.split(","); //splitting the string inputs by commas
	int [] listofNumbers = new int[div.length]; //Creating an array with size of the given input
    
	for(int k = 0; k <div.length; k++){ //Storing elements into the array that was created
    	listofNumbers[k] = Integer.parseInt(div[k]);
   	 
	}
	input.close();
    
	String answerDigit = "";
	int sizeCounter = 0;
    	//if(div.length == 0){
    		
    		
    	//}
    	while (sizeCounter != div.length){
        	if(div.length == 1){
            	System.out.println(div[0]);
            	System.exit(1);
           	 
        	}
       	 
    	String biggestDigit = Result(listofNumbers);
    	answerDigit = answerDigit + biggestDigit;
    	sizeCounter++;
   	 
   	 
    	}
   	 
    	System.out.println(answerDigit);
   	   	 
}



	public static String Result(int [] numbers){
    
        	String output = ""; //Creating an string to store the results to be returned at the end
         	
        	int temp = 0; //Temporary storage for each value
        	for (int i=0; i < numbers.length; i++){ //Loop that checks all the elements in the created array
           	 
            	int j = numbers.length - 1; //Start checking from the first element of the array with last element of the array
           	 
            	while (i < j){
               	 
                	int firstNumfirstDigit = Integer.parseInt(Integer.toString(numbers[i]).substring(0, 1)); //single digit of first input
                	int secondNumfirstDigit = Integer.parseInt(Integer.toString(numbers[j]).substring(0, 1)); //single digit of last input
                	int checkingNum = Integer.parseInt(Integer.toString(temp).substring(0, 1)); //single digit of what is in the temp value
               	 
                    	if((firstNumfirstDigit ==0) && (secondNumfirstDigit ==0)){ //if more than two numbers have been checked then move to the next number
                            	break;
                    	}
                    	if((firstNumfirstDigit == secondNumfirstDigit)){
                       	 
                       	int tempstore = checkingSameNum(numbers[i], numbers[j], temp);
                        	temp = tempstore;
                        	j--;
                    	}
                        	else
                        	{
                            	if(checkingNum != firstNumfirstDigit){
                               	 
                                 	if(firstNumfirstDigit > secondNumfirstDigit){ 	 
                                    	 
                                    	 
                                     	if(firstNumfirstDigit > checkingNum){ //Compare to see if numbers[i] is bigger than what is in the temp value, if so, modify
                                     	temp = numbers[i];
                                    	 
                                     	}
                                     	else{
                                     		//int checkingNum = Integer.parseInt(Integer.toString(temp).substring(0, 1));
                                     		if(secondNumfirstDigit > checkingNum){
                                     			temp = numbers[j];
                                     		}
                                     		j--;
                                     	}
                                     }
                                 	else{ //When SecondNumfirstDigit is bigger than firstNumfirstDigit
                                     	if(secondNumfirstDigit > checkingNum){
                                   		  temp = numbers[j];
                                   		  j--;
                                   		  break;
                                     	}

                                 	}
                            	}
                            	else
                            	{ //When first number is equal to what is in the temp store then you check which one is bigger
                                	int updatetemp = checkingSameNum(temp, numbers[j], temp);
                                	temp = updatetemp;
                               	 
                            	}
                     	j--;
            	}
                	}
               	 
        	}
       	 	//Once biggest number have been found, you would remove that value and update the list and append that integer to the string after coverting
        	removeNumber(numbers,temp);
        	Integer.toString(temp);
        	output = output + temp;

        	return output;
           	 
        	}

   
    
	public static int[] removeNumber (int [] listofNumbers, int biggestNum){
   	 
    	for(int k = 0; k <listofNumbers.length; k++){ //Storing elements into the array that was created
        	if(listofNumbers[k] == biggestNum){
            	{
                	listofNumbers[k] = 0;
                	break;
            	}
           	 
        	}    	 
    	}
    	return listofNumbers;
   	 
	}
    
	
	public static int checkingSameNum(int firstNum, int secondNum, int tempstore){
   	 
     	int firstNumfirstDigit = Integer.parseInt(Integer.toString(firstNum).substring(0, 1)); //single digit of first input
     	int secondNumfirstDigit = Integer.parseInt(Integer.toString(secondNum).substring(0, 1)); //single digit of last input
     	int checkingNum = Integer.parseInt(Integer.toString(tempstore).substring(0, 1));
   	 
    	if(firstNum != secondNum){
     
        	if(firstNum > secondNum){ //If first number is bigger than second number
            	if(firstNumfirstDigit > checkingNum){ //Compare to see if numbers[i] is bigger than what is in the temp value, if so, modify
                	tempstore = firstNum; //if so, first the first num to the tempstore
               	 
            	}
        	}
            	else{ //If second one is bigger then check to see if first number is bigger than what is stored
           		 if(firstNumfirstDigit == checkingNum){ 
           			 if(secondNumfirstDigit > checkingNum){ //If firstnum is equal to tempstore, then check if second num is bigger than in temp
           				 
           				 tempstore = secondNum;
           			 }
           			 else{
           				 tempstore = firstNum;
           			 }
           		 }
           		 else{
           			 //if second num is bigger, then check to see if secondnum is equal to temp value
                	if(secondNumfirstDigit == checkingNum){
                	tempstore = secondNum; //if so, store second num into temp
               	 
            	}
                	else{ //if they are not the same, then compare firstnum and second num; store which ever is bigger
                    	if(firstNum > secondNum){
                        	tempstore = firstNum;
                    	}
                    	else{
                        	tempstore = secondNum;
                    	}
                	}
           	 
            	}
       	}
     
    	}
    	else{
        	if(firstNum > secondNum){
            	tempstore = firstNum;
        	}
        	else{
            	tempstore = secondNum;
           	 
        	}
       	 
    	}
     	return tempstore;
   	 
 	}
 
   }
