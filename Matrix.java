public class Matrix {
  private int[][] data;

  public Matrix(int[][] data) {
    this.data = data;
  }

  public Matrix(int rows, int columns) {
    data = new int[rows][columns];
  }

  public int get(int row, int column) {
    return data[row][column];
  }

  public void set(int row, int column, int value) {
    data[row][column] = value;
  }

  public int getRowCount() {
    return data.length;
  }

  public int getColumnCount() {
    return data[0].length;
  }

  public Matrix getSubmatrix(int startRow, int startColumn, int rowCount, int columnCount) {
    int[][] subMatrixData = new int[rowCount][columnCount];
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < columnCount; j++) {
        subMatrixData[i][j] = data[startRow + i][startColumn + j];
      }
    }
    return new Matrix(subMatrixData);
  }

  public void print() {
    for (int i = 0; i < getRowCount(); i++) {
      for (int j = 0; j < getColumnCount(); j++) {
        System.out.print(data[i][j] + " ");
      }
      System.out.println();
    }
  }
}