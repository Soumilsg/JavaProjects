package CodeScanner;

/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

class Main {
  public static void main(String[] args){
    System.out.println("===== Running Question 1 =====");
    KeywordScanner keywordScanner = new KeywordScanner();
    keywordScanner.run();
    System.out.println("===== Running Question 2 =====");
    TrendObserver trendObserver = new TrendObserver();
    trendObserver.run();
    System.out.println("===== Running Question 3 =====");
    Q3 q3 = new Q3();
    q3.run();
    System.out.println("===== Running Question 4 =====");
    Isomorphic isomorphic = new Isomorphic();
    isomorphic.run();
  }
}