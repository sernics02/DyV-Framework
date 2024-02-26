import java.util.ArrayList;

public class QuickSort implements DivideAndConquerAlgorithm<ArrayList<Integer>> {
  @Override
  public Boolean isSmall(ArrayList<Integer> data) {
    return data.size() < 2;
  }

  @Override
  public ArrayList<Integer> solveSmall(ArrayList<Integer> data) {
    return data;
  }

  @Override
  public ArrayList<ArrayList<Integer>> decompose(ArrayList<Integer> data, Integer size) {
    ArrayList<ArrayList<Integer>> subproblems = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();
    Integer pivot = data.get(0);
    for (int i = 1; i < data.size(); i++) {
      if (data.get(i) < pivot) {
        left.add(data.get(i));
      } else {
        right.add(data.get(i));
      }
    }
    subproblems.add(left);
    subproblems.add(right);
    return subproblems;
  }

  @Override
  public ArrayList<Integer> combine(ArrayList<ArrayList<Integer>> solutions) {
    ArrayList<Integer> combined = new ArrayList<Integer>();
    combined.addAll(solutions.get(0));
    combined.addAll(solutions.get(1));
    return combined;
  }
}
