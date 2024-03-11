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
    ArrayList<TwoMatrix> submatrices = new ArrayList<>();

    int newSize = size / 2;
    Matrix a11 = data.getA().getSubmatrix(0, 0, newSize, newSize);
    Matrix a12 = data.getA().getSubmatrix(0, newSize, newSize, size);
    Matrix a21 = data.getA().getSubmatrix(newSize, 0, size, newSize);
    Matrix a22 = data.getA().getSubmatrix(newSize, newSize, size, size);

    Matrix b11 = data.getB().getSubmatrix(0, 0, newSize, newSize);
    Matrix b12 = data.getB().getSubmatrix(0, newSize, newSize, size);
    Matrix b21 = data.getB().getSubmatrix(newSize, 0, size, newSize);
    Matrix b22 = data.getB().getSubmatrix(newSize, newSize, size, size);

    TwoMatrix submatrix1 = new TwoMatrix(a11, b11);
    TwoMatrix submatrix2 = new TwoMatrix(a12, b12);
    TwoMatrix submatrix3 = new TwoMatrix(a21, b21);
    TwoMatrix submatrix4 = new TwoMatrix(a22, b22);

    submatrices.add(submatrix1);
    submatrices.add(submatrix2);
    submatrices.add(submatrix3);
    submatrices.add(submatrix4);

    return submatrices;
  }
  @Override
  public Matrix combine(ArrayList<Matrix> solutions) {
    int newSize = solutions.get(0).getRowCount();
    Matrix c = new Matrix(newSize * 2, newSize * 2);
    for (int i = 0; i < newSize; i++) {
      for (int j = 0; j < newSize; j++) {
        c.set(i, j, solutions.get(0).get(i, j));
        c.set(i, j + newSize, solutions.get(1).get(i, j));
        c.set(i + newSize, j, solutions.get(2).get(i, j));
        c.set(i + newSize, j + newSize, solutions.get(3).get(i, j));
      }
    }
    return c;
  }
  @Override
  public String getRecurrence() {
    return "8T(n/2) + O(n^2)";
  }
}
