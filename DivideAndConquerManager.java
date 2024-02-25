public class DivideAndConquerManager<T> {
  private DivideAndConquerAlgorithm<T> algorithm;

  public DivideAndConquerManager(DivideAndConquerAlgorithm<T> algorithm) {
      this.algorithm = algorithm;
  }

  public T execute(T problem) {
      return algorithm.solve(problem);
  }

  public String getRecurrence() {
      return algorithm.getRecurrence();
  }
}