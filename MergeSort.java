import java.util.ArrayList;

public class MergeSort implements DivideAndConquerAlgorithm<ArrayList<Integer>> {
  @Override
  public Boolean isSmall(ArrayList<Integer> data) {
    return data.size() <= 1;
  }

  @Override
  public ArrayList<Integer> solveSmall(ArrayList<Integer> data) {
    return data;
  }

  @Override
  public ArrayList<ArrayList<Integer>> decompose(ArrayList<Integer> data, Integer size) {
    ArrayList<ArrayList<Integer>> subproblems = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> subproblem1 = new ArrayList<Integer>();
    ArrayList<Integer> subproblem2 = new ArrayList<Integer>();
    for (int i = 0; i < data.size(); i++) {
      if (i < data.size() / 2) {
        subproblem1.add(data.get(i));
      } else {
        subproblem2.add(data.get(i));
      }
    }
    subproblems.add(subproblem1);
    subproblems.add(subproblem2);
    return subproblems;
  }

  @Override
  public ArrayList<Integer> combine(ArrayList<ArrayList<Integer>> solutions) {
    ArrayList<Integer> combined = new ArrayList<Integer>();
    ArrayList<Integer> solution1 = solutions.get(0);
    ArrayList<Integer> solution2 = solutions.get(1);
    int i = 0;
    int j = 0;
    while (i < solution1.size() && j < solution2.size()) {
      if (solution1.get(i) < solution2.get(j)) {
        combined.add(solution1.get(i));
        i++;
      } else {
        combined.add(solution2.get(j));
        j++;
      }
    }
    while (i < solution1.size()) {
      combined.add(solution1.get(i));
      i++;
    }
    while (j < solution2.size()) {
      combined.add(solution2.get(j));
      j++;
    }
    return combined;
  }
}
