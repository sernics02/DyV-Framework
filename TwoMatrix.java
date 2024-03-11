public class TwoMatrix {
  private Matrix a;
  private Matrix b;

  public TwoMatrix(Matrix a, Matrix b) {
    this.a = a;
    this.b = b;
  }

  public Matrix getA() {
    return a;
  }

  public Matrix getB() {
    return b;
  }

  // Implement n^3 matrix multiplication
  public Matrix multiply() {
    int n = a.getRowCount();
    Matrix c = new Matrix(n, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          c.set(i, j, c.get(i, j) + a.get(i, k) * b.get(k, j));
        }
      }
    }
    return c;
  }
}