import java.util.ArrayList;

public abstract class DivideAndConquerAlgorithm<T> {
  public abstract Boolean isSmall(T data);
  public abstract T solveSmall(T data);
  public abstract ArrayList<T> decompose(T data, Integer size);
  public abstract T combine(ArrayList<T> solutions);
  
  public T solve(T data, Integer size) {
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
  
  public T modification(T data, Integer size, Integer recursiveCalls, Integer maxRecursivityLevel) {
    if (isSmall(data)) {
      return solveSmall(data);
    } else {
      ArrayList<T> subproblems = decompose(data, size);
      ArrayList<T> solutions = new ArrayList<T>();
      maxRecursivityLevel++;
      if (maxRecursivityLevel > this.maxRecursivityLevel) {
        this.maxRecursivityLevel = maxRecursivityLevel;
      }
      for (T subproblem : subproblems) {
        recursiveCalls++;
        if (recursiveCalls > this.calls) {
          this.calls = recursiveCalls;
        }
        solutions.add(modification(subproblem, size, recursiveCalls, maxRecursivityLevel));
      }
      return combine(solutions);
    }
  }
  
  public abstract String getRecurrence();
  
  public Integer getRecursiveCalls() {
    return this.calls;
  }
  
  public Integer getMaxRecursivityLevel() {
    return this.maxRecursivityLevel;
  }
  
  private Integer maxRecursivityLevel = 0;
  private Integer calls = 0;
}
