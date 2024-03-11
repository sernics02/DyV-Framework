public class Matrix {
  private int[][] data;

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
}