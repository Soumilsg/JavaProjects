package Soumil_CS1B_Lab9_challenge1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/*
Challenge 1
Write a program that reads words from a text file and displays all the nonduplicate words in ascending order. Make sure your program has the main method that asks for a textfile.

Challenge 2
Write a program that prompts the user to enter a text file name and displays the number of vowels and consonants in the file. Use a set to store the vowels A, E, I, O, and U.
 */

public class Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a text file name: ");
        String filename = scanner.next();
        File fr = new File("C:\\Users\\Soumi\\IdeaProjects\\CS1B_lab1_challenge1\\src\\Soumil_CS1B_Lab9_challenge1\\" + filename);
        Set<String> words = setFiller(fr);
        System.out.println(words);

    }
    public static Set setFiller(File fr) {
        Set<String> words1 = new HashSet<>();
        try {
            Scanner scanner1 = new Scanner(fr);
            words1.add(scanner1.next());
            while (scanner1.hasNext()) {
                if (!words1.contains(scanner1.next())) {
                    words1.add(scanner1.next());
                }
            }
            System.out.println(words1.size());
            return words1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(words1);
        return words1;
    }
}
