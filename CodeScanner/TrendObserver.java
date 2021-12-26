/****************************************************/
/* Foothill College									
/* CS 01B - Intermediate Software Design in Java 	
/* Question 2                       
/* Prepared by Viet Trinh 							
/* Email: trinhviet@fhda.edu						
/****************************************************/
/*
Given a list of daily temperatures T, return a list such that, for each day in the input, tells
you how many days you would have to wait until a warmer temperature. If there is no
future day for which this is possible, put 0 instead.
• For example, given the list of temperatures
 T = [73, 74, 75, 71, 69, 72, 76, 73]
your output should be [1, 1, 4, 2, 1, 1, 0, 0]
Note: The length of temperatures will be in the range [1, 300]
 */
import java.util.*;

public class TrendObserver {
  public static void run() {
    int[] T1 = {73, 74, 75, 71, 69, 72, 76, 73};
    int[] T2 = {69, 74, 50, 71, 72, 68, 65, 63};
    printResults(dailyTemperatures(T1));
    printResults(dailyTemperatures(T2));
  }

  public static void printResults(int[] T) {
    System.out.println(Arrays.toString(T));
  }

  public static int[] dailyTemperatures(int[] T) {
    int[] t = new int[T.length];
    int i = 0;
    Stack<Integer> stack = new Stack<>();
    for (; i < (T.length - 2); i++) {
      int count = 0;
      int j = i;
      while ((j < (T.length - 2)) && (T[j + 1] < T[i])) {
        stack.push(T[j++]);
      }
      if (j == T.length) {
        while (!stack.empty())
          stack.pop();
        t[i] = 0;
      }
      else {
        count++;
        while (!stack.empty()) {
          stack.pop();
          count++;
        }
      }
      t[i] = count;
    }
    return t;
  }
}