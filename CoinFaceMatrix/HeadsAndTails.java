import java.util.Scanner;

public class HeadsAndTails {

	/* matrixCreator Method:
	 * Prints out a 3 x 3 matrix consisting of "Heads" and "Tails" based on binary version of the parameter variable
	 * @param "number" is the user's valid integer input between 0 and 511
	 */

	public static void matrixCreator(int number) { //Assign the user's input data to a parameter variable with the same name

		String convertTostring = Integer.toBinaryString(number); // Get the binary code of the number as a string and assign it to one
		int binary = Integer.parseInt(convertTostring); // Convert the string into an integer value
		int binaryLength = convertTostring.length(); // Use the string to get the length of the binary value and assign the length to a integer
		int zerosLength = 9 - binaryLength; // "zerosLength" will be used to see how many zeros to print out. The difference between 9 and the binary length calculates such

		int[] binaryValues = new int[9]; // Create an integer-type array

		for(int i = 0; i < zerosLength; i++) { // Assign the first "zerosLength" values to 0
			binaryValues[i] = 0;
		}

		char conversion = ' ';
		for(int i = zerosLength; i < binaryValues.length; i++ ) { // Assign the rest of the elements to the binary form of the user's input using char
			conversion = convertTostring.charAt(i-zerosLength);
			binaryValues[i] = Character.getNumericValue(conversion);
		}

		char[] headOrtail = new char[binaryValues.length]; // Create a char-type array with the same length as the integer one
		for(int i = 0; i < headOrtail.length; i++) { // Based on whether the integer array holds a 1 or a 0, assign the corresponding numbered char element to "H" or "T"
			if(binaryValues[i] == 0) {
				headOrtail[i] = 'H';
			}
			else if(binaryValues[i] == 1) {
				headOrtail[i] = 'T';
			}
		}
		for(int i = 0; i < headOrtail.length; i += 3) { // This for loop is able to print out the matrix without having multiple print statements
			System.out.println(headOrtail[i] + " " + headOrtail[i+1] + " " + headOrtail[i+2]);
		}
		return; // Because method is void, it will return nothing
	}

	public static void main(String[] args) {

		int number = 0;
		String runAgain = " ";
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Please input a number between 0 and 511: ");
			number = input.nextInt();
			while(number < 0 || number > 511) { // Loop makes sure the user inputs a integer in range
				System.out.println("Oops! Please try Again. ");
				number = input.nextInt();
			}
			matrixCreator(number); // Call the matrixCreator method, send user's valid input
			System.out.println("Would you like to enter another number? Enter \"Yes\" to do so, and \"No\" to exit program. ");
			runAgain = input.next();
		}
		while(!runAgain.equalsIgnoreCase("No")); // Whether the user inputed "No," will automatically be checked by the terminating condition
	}
}
