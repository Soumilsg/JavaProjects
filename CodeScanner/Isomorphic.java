import java.util.ArrayList;
import java.util.List;

/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

public class Isomorphic {
  public static void run() {
    System.out.println(isIsomorphic("egg", "add"));
    System.out.println(isIsomorphic("foo", "bar"));
    System.out.println(isIsomorphic("paper", "title"));
  }

  public static boolean isIsomorphic(String s, String t) {
      List<Character> list1 = new ArrayList<>();
      List<Character> list2 = new ArrayList<>();

      for(int i = 0; i < s.length(); i++){
        int integer1 = list1.indexOf(s.charAt(i));
        int integer2 = list2.indexOf(t.charAt(i));
        if(integer1 != integer2)
          return false;
        list1.add(s.charAt(i));
        list2.add(t.charAt(i));
      }
      return true;
    }
}