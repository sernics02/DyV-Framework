import java.util.ArrayList;

public abstract class DivideAndConquerAlgorithm<Problem, Solution> {
  private Integer maxRecursivityLevel = 0;
  private Integer calls = 0;

  public abstract Boolean isSmall(Problem data);
  public abstract Solution solveSmall(Problem data);
  public abstract ArrayList<Problem> decompose(Problem data, Integer size);
  public abstract Solution combine(ArrayList<Solution> solutions);
  
  public Solution solve(Problem data, Integer size) {
    if (isSmall(data)) {
      return solveSmall(data);
    } else {
      ArrayList<Problem> subproblems = decompose(data, size);
      ArrayList<Solution> solutions = new ArrayList<Solution>();
      for (Problem subproblem : subproblems) {
        solutions.add(solve(subproblem, size));
      }
      return combine(solutions);
    }
  }
  
  public Solution modification(Problem data, Integer size) {
    return modification(data, size, 0, 0);
  }
  
  public Solution modification(Problem data, Integer size, Integer recursiveCalls, Integer maxRecursivityLevel) {
    if (isSmall(data)) {
      return solveSmall(data);
    } else {
      ArrayList<Problem> subproblems = decompose(data, size);
      ArrayList<Solution> solutions = new ArrayList<Solution>();
      maxRecursivityLevel++;
      if (maxRecursivityLevel > this.maxRecursivityLevel) {
        this.maxRecursivityLevel = maxRecursivityLevel;
      }
      for (Problem subproblem : subproblems) {
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
}