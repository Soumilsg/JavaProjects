import java.util.Scanner;
import java.util.Stack;

/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

/*
Given an encoded string, return its decoded string
• The encoding rule is: k[encoded_string], where the encoded_string inside the
square brackets is being repeated exactly k times, and k > 0
• You may assume that the input string is always valid
• No extra white spaces, square brackets are well-formed, etc.
• The original data does not contain any digits and that digits are only for
those repeat numbers, k. For example, there won't be input like 3a or 2[4].
Examples
• s = "3[a]2[bc]", return "aaabcbc"
• s = "3[a2[c]]", return "accaccacc"
• s = "2[abc]3[cd]ef", return "abcabccdcdcdef"
 */

public class StringDecoder {
  public static void run() {
    System.out.println(encoded("3[a]2[bc]"));
    System.out.println(encoded("3[a2[c]]"));
    System.out.println(encoded("2[abc]3[cd]ef"));
  }


  public static String encoded(String s) {
    Scanner scanner = new Scanner(s);
    Stack<String> strStack = new Stack<String>();
    Stack<Integer> numStack = new Stack<Integer>();
    String decoded;
    StringBuilder sb = new StringBuilder();
    int count;
    char[] charArray = s.toCharArray();
    System.out.println("Input " + s);

    for(int i = 0; i < s.length(); i++){
      if(Character.isDigit(charArray[i])) {
        count = Integer.parseInt(String.valueOf(charArray[i]));
        numStack.push(count);
      }
      else if (charArray[i] == '[')
      {
        strStack.push(sb.toString());
        sb = new StringBuilder(""); // reset sb
      }
      else if (charArray[i] == ']') {
        count = numStack.pop();
        StringBuilder temp = new StringBuilder (strStack.pop());
         for (int k=0;k<count;k++){
          temp.append(sb);
        }
         sb = temp;
      }
      else
        sb.append(charArray[i]);
    }
    decoded = sb.toString();
    return decoded;
  }




}