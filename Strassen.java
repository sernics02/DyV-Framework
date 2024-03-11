import java.util.ArrayList;

public class Strassen extends DivideAndConquerAlgorithm<TwoMatrix, Matrix>{
  @Override
  public Boolean isSmall(TwoMatrix data) {
    return data.getA().getRowCount() <= 2;
  }
  @Override
  public Matrix solveSmall(TwoMatrix data) {
    return data.multiply();
  }
  @Override
  public ArrayList<TwoMatrix> decompose(TwoMatrix data, Integer size) {
    return null;
  }
  @Override
  public Matrix combine(ArrayList<Matrix> solutions) {
    return null;
  }
  @Override
  public String getRecurrence() {
    return "8T(n/2) + O(n^2)";
  }
}
