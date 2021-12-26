import java.util.Scanner;

/****************************************************/
/* Adapted from CS36A - Introduction to Computer Programming Using Java
/* By Soumil Gupta
/****************************************************/

class VendingMachine {

	//I have added methods here before the main one to increase readability because there are some tasks which will be repeated multiple times for different parts of the code

	public static String menu(){ //This is a method which when referred to will print the menu and take a food item selection from the user

		System.out.println("Here is the Menu");
		System.out.println("Potato Chips = $1.25");
		System.out.println("Cookies = $0.85");
		System.out.println("Candies = $0.95");
		System.out.println("Exit");

		Scanner foodEntered = new Scanner(System.in);
		System.out.print("Please enter one food item or 'Exit' : ");

		String choice = foodEntered.nextLine();

		while(!(choice.contains("Potato Chips") ||
				choice.contains("Cookies") ||
				choice.contains("Candies") ||
				choice.contains("Exit"))
				/*This while loop makes sure the user inputs only an option to which the vending machine can give a result.
				I realized I could make it easier to see by making the condition syntax appear vertical*/

				)
		{
			System.out.println("Oops! Please enter again: ");
			choice = foodEntered.nextLine();
		}
		return choice; //The method returns the user's food choice
	}



	public static double getMoney() { // This is a method which will take in and calculate how many Quarters, Dimes, and Nickels the user has entered

		Scanner moneyGiven = new Scanner(System.in);

		System.out.println("Please enter amount of Quarters, Dimes, and Nickels you have: ");

		System.out.println("Quarters: ");
		int quarters = moneyGiven.nextInt();
		double amount = (quarters * 0.25);

		System.out.println("Dimes: ");
		int dimes = moneyGiven.nextInt();
		amount += dimes * 0.10;

		System.out.println("Nickels: ");
		int nickels = moneyGiven.nextInt();
		amount += nickels * 0.05;

		System.out.printf("You deposited: $%5.2f\n", amount);
		return amount; 		// I return the total amount of money in dollars the user has inputed
	}



	public static void giveChange(double balanceAmount, double priceOfItem) { // Assign a value to parameter values for method, so values can be used in method
		int changeCents = 0;

		if(balanceAmount > priceOfItem) {
			changeCents = (int)((balanceAmount - priceOfItem) * 100+1);
			/*Adding one cent will make sure that change is returned exactly as float may not be stored exactly due to loss of precision.
			Online I found that adding one will make sure that I get exactly the money I want and rids the precision problem */

			//The following statements calculate the change in Quarters, Dimes and Nickels
			int changeQuarters = (changeCents/25);
			changeCents -= changeQuarters * 25;
			int changeDimes = (changeCents/10);
			changeCents -= changeDimes * 10;
			int changeNickels = (changeCents/5);
			changeCents -= changeNickels * 5;

			System.out.printf("For your total amount of money entered: $%3.2f", balanceAmount);
			System.out.println(", here is your change: " + "Quarters: " + changeQuarters + ", " + "Dimes: " + changeDimes + ", " + "Nickels: " + changeNickels);

		}
	}


	public static void main(String[] args) {	//The main method is where the program starts


		//Create a list of variables which I will use in loop. Variables are in scope of everything in loop this way.

		Scanner input = new Scanner(System.in);

		//Stock of foods
		int amountOfchips = 3;
		int amountOfcookies = 3;
		int amountOfcandies = 3;

		//Constant prices of foods
		final double priceOfchips = 1.25;
		final double priceOfcookies = 0.85;
		final double priceOfcandies = 0.95;

		double amount1 = 0;  //Refers to the amount of money customer entered initially in main method
		String choice1 = ""; //Refers to the food choice of customer
		String choice2 = ""; //Refers to "Exit" or "Enter more Money" options so user can either leave or pay amount needed for desired food

		double amount2 = 0.0; //Amount2 is the next round of coin input from the user if they didn't put enough initially
		double disparity = 0.0; //Disparity refers to the remaining amount of money a user needs to input to get desired food

		String answer = ""; //Refers to whether the user wants to buy more food or leave



		do {	// This "Do-While" loop allows the program to run at least once, and continue until the user wants to "Exit" (Leave vending machine)

			choice1 = menu(); // menu returns string that is now stored in String choice1 in "Do-While" loop

			if (choice1.contentEquals("Exit"))	break; //If string choice refers to "Exit," the program will end

			if (choice1.contains("Potato Chips")) { //Statements to command vending machine if the user wants potato chips

				/*Please keep in mind that I have added delimiters to the first part of the loop pertaining
				 * to Potato chips, and the remaining If statement parts and the contents inside their scope are copies of the
				 * Potato chip parts but pertain to Cookies or Candies.
				 */

				amount1 += getMoney(); // getMoney method returns double that is now stored in double amount1 in "Do-While" loop

				if(amountOfchips <= 0) { //If Statement is for if the vending machine is out stock for a specific food
					System.out.println("Uh-Oh! We are out of stock of Potato Chips!");
					System.out.println("Please take your money back.");
					System.out.println("Would you like to order something else? Enter 'Yes' to place your order and pay again. Enter 'Exit' to exit program. ");
					answer = input.nextLine();

					if(answer.contains("Yes")) { //Continue means the program will go all the way to the end of the loop and repeat to go back to the menu method again
						amount1 = 0; //Assign amount1 to Zero so the previous deposit is not considered in the next order
						continue;
					}
					else if (answer.contains("Exit")){ //Exit means the program will go all the way to the end of the loop and then terminate program
						choice1 = "Exit";
					}
				}
				else {
					while(amount1 < priceOfchips) { //While loop will persist unless user inputs enough money or leaves
						disparity = priceOfchips - amount1;
						System.out.printf("Uh-Oh! You do not have enough money! You are short by: $%5.2f\n", disparity);
						System.out.println("Please enter 'Enter More Money' to give more money and recieve your Potato chips or enter 'Exit' ");
						choice2 = input.nextLine();
						if(choice2.contains("Exit")) {
							choice1 = "Exit";
							break;
						}
						else if(choice2.contains("Enter More Money")) {
							amount2 += getMoney(); //Calls get money method to happen again
							amount1 += amount2;
							/*Additionaly money entered is added to the amount of money initially entered.
							That way, the user only needs to enter additional money (Not all his money again) in order to buy his food choice*/
						}
					}

					if (amount1 >= priceOfchips) { //If user inputed enough money
						System.out.println("Please take your food");
						if(amount1 > priceOfchips) { //If user inputed too much money, the give change method is called and change is calculated and given back
							giveChange(amount1, priceOfchips);
						}
						amountOfchips--; //Decreases stock of Potato Chips
						System.out.println("Would you like anything else? Enter 'Yes' to place your order and pay again. Enter 'Exit' to exit program. ");
						answer = input.nextLine();

						if(answer.contains("Yes")) { //Continue will allow program to repeat loop and therefore go back to call for the menu method
							amount1 = 0; //Assign amount1 to Zero so the previous deposit is not considered in the next order
							continue;
						}
						else if (answer.contains("Exit")){ //Exit will allow the loop to exit once program reaches end of "do" section again
							choice1 = "Exit";
						}
					}
				}
			}


			if(choice1.contains("Cookies")) { //Same statments but used for if user wants cookies

				amount1 += getMoney();

				if(amountOfcookies <= 0) {
					System.out.println("Uh-Oh! We are out of stock of Cookies!");
					System.out.println("Please take your money back.");
					System.out.println("Would you like to order something else? Enter 'Yes' to place your order and pay again. Enter 'Exit' to exit program. ");
					answer = input.nextLine();

					if(answer.contains("Yes")) {
						amount1 = 0;
						continue;
					}
					else if (answer.contains("Exit")){
						choice1 = "Exit";
					}
				}
				else {
					while(amount1 < priceOfcookies) {
						disparity = priceOfcookies - amount1;
						System.out.printf("Uh-Oh! You do not have enough money! You are short by: $%5.2f\n", disparity);
						System.out.println("Please enter 'Enter More Money' to give more money and recieve your Potato chips or enter 'Exit' ");
						choice2 = input.nextLine();

						if(choice2.contains("Exit")) {
							choice1 = "Exit";
							break;
						}
						else if(choice2.contains("Enter More Money")) {
							amount2 += getMoney();
							amount1 += amount2;
						}
					}

					if (amount1 >= priceOfcookies) {
						System.out.println("Please take your food");

						if(amount1 > priceOfcookies) {
							if(amount1 > priceOfcookies) {
								giveChange(amount1, priceOfcookies);
							}
						}
						amountOfcookies--;

						System.out.println("Would you like anything else? Enter 'Yes' to place your order and pay again. Enter 'Exit' to exit program. ");
						answer = input.nextLine();

						if(answer.contains("Yes")) {
							amount1 = 0;
							continue;
						}
						else if (answer.contains("Exit")){
							choice1 = "Exit";
						}
					}
				}
			}


			if(choice1.contains("Candies")) { //Same statments but used for if user wants candies

				amount1 += getMoney();

				if(amountOfcandies <= 0) {
					System.out.println("Uh-Oh! We are out of stock of Candies!");
					System.out.println("Please take your money back.");
					System.out.println("Would you like to order something else? Enter 'Yes' to place your order and pay again. Enter 'Exit' to exit program. ");
					answer = input.nextLine();

					if(answer.contains("Yes")) {
						amount1 = 0;
						continue;
					}
					else if (answer.contains("Exit")){
						choice1 = "Exit";
					}
				}
				else {
					while(amount1 < priceOfcandies) {
						disparity = priceOfcandies - amount1;
						System.out.printf("Uh-Oh! You do not have enough money! You are short by: $%5.2f\n", disparity);
						System.out.println("Please enter 'Enter More Money' to give more money and recieve your Potato chips or enter 'Exit' ");
						choice2 = input.nextLine();

						if(choice2.contains("Exit")) {
							choice1 = "Exit";
							break;
						}
						else if(choice2.contains("Enter More Money")) {
							amount2 += getMoney();
							amount1 += amount2;
						}
					}

					if (amount1 >= priceOfcandies) {
						System.out.println("Please take your food");

						if(amount1 > priceOfcandies) {
							giveChange(amount1, priceOfcandies);
						}
						amountOfcandies--;

						System.out.println("Would you like anything else? Enter 'Yes' to place your order and pay again. Enter 'Exit' to exit program. ");
						answer = input.nextLine();

						if(answer.contains("Yes")) {
							amount1 = 0;
							continue;
						}
						else if (answer.contains("Exit")){
							choice1 = "Exit";
						}

					}
				}
			}
		}
		while(!choice1.contentEquals("Exit"));
	}
}

