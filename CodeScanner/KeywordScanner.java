import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

/*Write a program that reads a Java source-code file and reports the number of keywords
(including null, true, and false) in the file. If a keyword is in a comment or in a string, don't
count it. Test your program to count the keywords in the file Main.java.
Hint: Create a set to store all the Java keywords
 */

public class KeywordScanner {
  public static void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter a text file name: ");
    String filename = scanner.next();
    identifier(filename);
  }

  public static void identifier(String filename) {
    // Read the keywords from the file.
    File kwd = new File("C:\\Users\\Soumi\\OneDrive\\Desktop\\assign3\\" + "Keywords.txt");
    Set<String> javakeywords = new HashSet<String>();
    try {
      Scanner scanner1 = new Scanner(kwd);
      while (scanner1.hasNextLine()) {
        String keyword = scanner1.nextLine();
        javakeywords.add(keyword);
      }
      // Scan the  input java file
      File fr = new File("C:\\Users\\Soumi\\OneDrive\\Desktop\\assign3\\" + filename);
      Scanner scanner2 = new Scanner(fr);
      int keywordcount = 0;
      boolean inCommentBlock = false;
      while (scanner2.hasNextLine()) {
        String line = scanner2.nextLine();

        Scanner scanword = new Scanner(line);
        while (scanword.hasNext())
        {
          String word = scanword.next();
          if(word.startsWith("//")){
            break; // skip to next line stop scanning this line.
          }
          else if(word.startsWith("/*")){
            inCommentBlock = true;
          }

          if (inCommentBlock && word.contains("*/"))
          {
            inCommentBlock = false;
          }

          if (!(inCommentBlock) && javakeywords.contains(word)) {
            keywordcount++;
          }
        } // End of scanning the line
      }
      System.out.println ("File " + filename + " Key Word Count = " + keywordcount);
    } catch (FileNotFoundException e) {
      System.out.println("Cannot read File ");
    }
  }
}