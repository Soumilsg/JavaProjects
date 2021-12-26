/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Alphabetizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a text file name: ");
        String filename = scanner.next();
        File fr = new File("C:\\Users\\Soumi\\IdeaProjects\\CS1B_lab1_challenge1\\src\\Soumil_CS1B_Lab9_challenge1\\" + filename);
        SortedSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        try {
            Scanner scanner1 = new Scanner(fr);
            while (scanner1.hasNext()) {
                words.add(scanner1.next().replaceAll("[0-9, , 's, ., $]",""));
            }
            words.remove(new String(""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(words);
    }

}
