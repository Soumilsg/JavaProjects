package Soumil_CS1B_Assignment1;
/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;

public class BabyNameRanking {
	public static void run() throws Exception {
		String[][] boyNames = new String[3][1000];
		String[][] girlNames = new String[3][1000];
		//String databaseLocation = "babynameranking/";
		String databaseLocation = "C:\\Users\\Soumi\\IdeaProjects\\CS1B_lab1_challenge1\\out\\production\\CS1B_lab1_challenge1\\Soumil_CS1B_Assignment1\\babynameranking\\";

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the gender: ");
		String gender = input.next();
		System.out.print("Enter the name: ");
		String name = input.next();

		System.out.println("You entered year "+year);
		System.out.println("You entered gender "+gender);
		System.out.println("You entered name "+name);

		String filename = databaseLocation + "babynameranking" + year + ".txt";
		System.out.println("Reading File: " + filename);

		File fr = new File(filename);
		try {
			Scanner sc = new Scanner(fr);
			int i = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				//  System.out.println("Read Line: " + line);
				Scanner lineScanner = new Scanner(line);
				String rank = lineScanner.next();
				String male_name = lineScanner.next();
				String male_number = lineScanner.next();
				String female_name = lineScanner.next();
				String female_number = lineScanner.next();
				boyNames[0][i] = rank;
				boyNames[1][i] = male_name.toUpperCase();
				boyNames[2][i] = male_number;
				girlNames[0][i] = rank;
				girlNames[1][i] = female_name.toUpperCase();
				girlNames[2][i] = female_number;
				i++;
			}
		} catch (Exception e) {
			System.out.println("Exception in reading from File");
			e.printStackTrace();
		}

		int rank = 0;
		if (gender.compareToIgnoreCase("M") == 0){
			rank = getRank(boyNames, 1000, name.toUpperCase());
		}
		else
			rank = getRank(girlNames, 1000, name.toUpperCase());

		if (rank == -1) {
			System.out.println ("Name: " + name + " is not found in the popular names for year " + year);
		}
		else
			System.out.println ( name + " is ranked # " + rank + " in the year " + year);
	}

	static int getRank(String[][] list, int size, String name) {
		int value = -1;
		System.out.println("Searching for key : " + name);
		for (int i = 0; i < size; i++){
			if (list[1][i].equals(name.toUpperCase())) {
				value = Integer.parseInt(list[0][i]);
			}
		}
		return value;
	}
}
