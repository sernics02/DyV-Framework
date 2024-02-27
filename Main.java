import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Integer size = 10;
    ArrayList<Integer> data = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      data.add((int) (Math.random() * 100));
    }
    System.out.println(data);
    DivideAndConquerAlgorithm<ArrayList<Integer>> mergeSort = new MergeSort();
    ArrayList<Integer> sorted = mergeSort.solve(data, size);
    System.out.println(sorted);
  }
}
