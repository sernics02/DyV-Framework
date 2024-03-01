import java.util.ArrayList;

public interface DivideAndConquerAlgorithm<T> {
  public abstract Boolean isSmall(T data);
  public abstract T solveSmall(T data);
  public abstract ArrayList<T> decompose(T data, Integer size);
  public abstract T combine(ArrayList<T> solutions);
  public default T solve(T data, Integer size) {
    if (isSmall(data)) {
      return solveSmall(data);
    } else {
      ArrayList<T> subproblems = decompose(data, size);
      ArrayList<T> solutions = new ArrayList<T>();
      for (T subproblem : subproblems) {
        solutions.add(solve(subproblem, size));
      }
      return combine(solutions);
    }
  }
  public abstract String getRecurrence();
}
