package Soumil_CS1B_Lab9_challenge2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LetterParser {
    /*
Challenge 1
Write a program that reads words from a text file and displays all the nonduplicate words in ascending order. Make sure your program has the main method that asks for a textfile.

Challenge 2
Write a program that prompts the user to enter a text file name and displays the number of vowels and consonants in the file. Use a set to store the vowels A, E, I, O, and U.
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a text file name: ");
        String filename = scanner.next();
        File fr = new File("C:\\Users\\Soumi\\IdeaProjects\\CS1B_lab1_challenge1\\src\\Soumil_CS1B_Lab9_challenge2\\" + filename);
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        System.out.println(vowels);
        Counter(fr, vowels);

    }
    public static void Counter(File fr, Set vowels){
        String word = " ";
        int vowelCount = 0;
        int consonantCount = 0;
        try {
            Scanner scanner1 = new Scanner(fr);
            while(scanner1.hasNext()){
                word = (scanner1.next()).toUpperCase();
                char[] letters = word.toCharArray();
                for(int i = 0; i < letters.length; i++){
                    if(vowels.contains(letters[i])){
                        vowelCount++;
                    }
                    else if(Character.isAlphabetic(letters[i])){
                        consonantCount++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(vowelCount);
        System.out.println(consonantCount);
    }
}
