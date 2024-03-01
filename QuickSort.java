import java.util.ArrayList;

public class QuickSort implements DivideAndConquerAlgorithm<ArrayList<Integer>> {
  @Override
  public Boolean isSmall(ArrayList<Integer> data) {
    return data.size() <= 1;
  }

  @Override
  public ArrayList<ArrayList<Integer>> decompose(ArrayList<Integer> data, Integer subproblemSize) {
    Integer pivot = data.get(data.size() / 2);
    ArrayList<ArrayList<Integer>> subproblems = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> subproblem1 = new ArrayList<Integer>();
    ArrayList<Integer> subproblem2 = new ArrayList<Integer>();
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i).compareTo(pivot) < 0) {
        subproblem1.add(data.get(i));
      } else {
        if (data.get(i).compareTo(pivot) > 0)
        subproblem2.add(data.get(i));
      }
    }
    subproblems.add(subproblem1);
    ArrayList<Integer> pivotList = new ArrayList<Integer>();
    pivotList.add(pivot);
    subproblems.add(pivotList);
    subproblems.add(subproblem2);
    return subproblems;
  }

  @Override
  public ArrayList<Integer> solveSmall(ArrayList<Integer> smallProblem) {
    return smallProblem;
  }

  @Override
  public ArrayList<Integer> combine(ArrayList<ArrayList<Integer>> subproblemSolutions) {
    ArrayList<Integer> combined = new ArrayList<Integer>();
    // Combine the solutions of the subproblems here
    for (ArrayList<Integer> subproblemSolution : subproblemSolutions) {
      for (Integer element : subproblemSolution) {
        combined.add(element);
      }
    }
    return combined;
  }

  @Override
  public String getRecurrence() {
    return "2T(n/2) + O(n)";
  }
}