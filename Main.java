import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Integer size = 10000;
    ArrayList<Integer> data = generateArray(size);

    long startTime = System.currentTimeMillis();
    DivideAndConquerAlgorithm<ArrayList<Integer>> mergeSort = new MergeSort();
    ArrayList<Integer> mergeSorted = mergeSort.solve(data, size);
    long endTime = System.currentTimeMillis();
    long mergeTime = endTime - startTime;
    
    startTime = System.currentTimeMillis();
    DivideAndConquerAlgorithm<ArrayList<Integer>> quickSort = new QuickSort();
    ArrayList<Integer> quickSorted = quickSort.solve(data, size);
    endTime = System.currentTimeMillis();
    long quickTime = endTime - startTime;
    generateTableResults(mergeTime, quickTime);
  }
  public static ArrayList<Integer> generateArray(Integer size) {
    ArrayList<Integer> data = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      data.add((int) (Math.random() * 100));
    }
    return data;
  }
  public static void generateTableResults(long mergeTime, long quickTime) {
    System.out.println("Merge Sort Time: " + mergeTime + "ms");
    System.out.println("Quick Sort Time: " + quickTime + "ms");
  }
}
