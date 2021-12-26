/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

import java.util.Scanner;
import java.io.File;

public class BabyNameSameGender {
	public static void run() {
	//	String databaseLocation = "babynameranking/";
		String databaseLocation = "C:\\Users\\Soumi\\IdeaProjects\\CS1B_lab1_challenge1\\out\\production\\CS1B_lab1_challenge1\\Soumil_CS1B_Assignment1\\babynameranking\\";

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name for baby name ranking: ");
		String fileName = input.next();

		String[][] boyNames = new String[3][1000];
		String[][] girlNames = new String[3][1000];

		String filestring = databaseLocation +  fileName;
		System.out.println("Reading File: " + filestring);

		File fr = new File(filestring);
		try {
			Scanner sc = new Scanner(fr);
			int i = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

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

		findCommonValues(boyNames, girlNames, 1000);
	}

	static void findCommonValues (String[][] list1, String[][] list2, int size) {
		String common[] = new String[1000];
		int j = 0;
		for (int i = 0; i < size; i++){
			if (list1[1][i].equals(list1[1][i])) {
				common[j++] = list1[1][i];
			}
		}
		if (j != 0){
			System.out.println(j + " names used for both genders.");
			System.out.println("They are :");
			for (int i = 0; i < j; i++){
				System.out.println(common[i]);
			}
		}
	}
}