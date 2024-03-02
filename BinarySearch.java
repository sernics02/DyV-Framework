public class BinarySearch<T extends Comparable<T>> implements DivideAndConquerAlgorithm<T> {
  public BinarySearch(T target) {
    this.target = target;
  }
  
  private T target;
}
