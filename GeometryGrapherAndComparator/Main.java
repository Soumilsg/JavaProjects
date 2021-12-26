/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("===== Running Question 1 =====");
    AreaComparator areaComparator = new AreaComparator();
    areaComparator.run();
    System.out.println("===== Running Question 2 =====");
    DirectoryCounter directoryCounter = new DirectoryCounter();
    directoryCounter.run();
    System.out.println("===== Running Question 3 =====");
    StructureGenerator structureGenerator = new StructureGenerator();
    structureGenerator.run();
  }
}