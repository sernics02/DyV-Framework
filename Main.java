import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    Integer size = 100;
    ArrayList<Integer> data = generateArray(size);

    long startTime = System.currentTimeMillis();
    DivideAndConquerAlgorithm<ArrayList<Integer>, ArrayList<Integer>> mergeSort = new MergeSort();
    int mergeRecursiveCalls = 0;
    Integer mergeMaxRecursivityLevel = 0;
    ArrayList<Integer> mergeSorted = mergeSort.modification(data, size, mergeRecursiveCalls, mergeMaxRecursivityLevel);
    mergeRecursiveCalls = mergeSort.getRecursiveCalls();
    mergeMaxRecursivityLevel = mergeSort.getMaxRecursivityLevel();
    long endTime = System.currentTimeMillis();
    long mergeTime = endTime - startTime;
    
    startTime = System.currentTimeMillis();
    Integer quickRecursiveCalls = 0;
    Integer quickMaxRecursivityLevel = 0;
    DivideAndConquerAlgorithm<ArrayList<Integer>, ArrayList<Integer>> quickSort = new QuickSort();
    ArrayList<Integer> quickSorted = quickSort.modification(data, size, quickRecursiveCalls, quickMaxRecursivityLevel);
    quickRecursiveCalls = quickSort.getRecursiveCalls();
    quickMaxRecursivityLevel = quickSort.getMaxRecursivityLevel();
    endTime = System.currentTimeMillis();
    long quickTime = endTime - startTime;
    generateTableResults(mergeTime, mergeRecursiveCalls, mergeMaxRecursivityLevel, quickTime, quickRecursiveCalls, quickMaxRecursivityLevel);
    toFile(mergeSorted, "solutions.txt");
    // toFile(quickSorted, "solutions.txt");
  }
  public static ArrayList<Integer> generateArray(Integer size) {
    ArrayList<Integer> data = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      data.add((int) (Math.random() * size));
    }
    return data;
  }
  public static void generateTableResults(long mergeTime, Integer mergeRecursiveCalls, Integer mergeMaxRecursivityLevel, long quickTime, Integer quickRecursiveCalls, Integer quickMaxRecursivityLevel) {
    System.out.println("----------------------------------------------------------------------");
    System.out.println("| Algorithm    | Time (ms) | Recursive Calls | Max Recursivity Level |");
    System.out.println("----------------------------------------------------------------------");
    System.out.printf("| Merge Sort   | %9d | %15d | %21d |\n", mergeTime, mergeRecursiveCalls, mergeMaxRecursivityLevel);
    System.out.printf("| Quick Sort   | %9d | %15d | %21d |\n", quickTime, quickRecursiveCalls, quickMaxRecursivityLevel);
    System.out.println("----------------------------------------------------------------------");
    System.out.println();
  }
  public static void toFile(ArrayList<Integer> data, String filename) {
    try {
      FileWriter file = new FileWriter(filename);
      for (Integer number : data) {
        file.write(number + " ");
      }
      file.write("\n");
      file.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
