import java.util.ArrayList;

public class BinarySearch extends DivideAndConquerAlgorithm<BinarySearch.SearchData, Integer> {
  public static class SearchData {
    public ArrayList<Integer> array;
    public int target;
    public int start;
    public int end;

    public SearchData(ArrayList<Integer> array, int target, int start, int end) {
      this.array = array;
      this.target = target;
      this.start = start;
      this.end = end;
    }
  }

  public Boolean isSmall(SearchData data) {
    return data.start == data.end;
  }

  public Integer solveSmall(SearchData data) {
    if (data.array.get(data.start) == data.target) {
      return data.start;
    } else {
      return -1; // Elemento no encontrado
    }
  }

  public ArrayList<SearchData> decompose(SearchData data, Integer size) {
    ArrayList<SearchData> subproblems = new ArrayList<>();
    int mid = (data.start + data.end) / 2;
    subproblems.add(new SearchData(data.array, data.target, data.start, mid));
    subproblems.add(new SearchData(data.array, data.target, mid + 1, data.end));
    return subproblems;
  }

  public Integer combine(ArrayList<Integer> solutions) {
    int leftResult = solutions.get(0);
    int rightResult = solutions.get(1);
    
    if (leftResult != -1) {
      return leftResult;
    } else if (rightResult != -1) {
      return rightResult;
    } else {
      return -1; // Elemento no encontrado
    }
  }

  public String getRecurrence() {
    return "T(n) = 2T(n/2) + O(1)";
  }
}
