import java.util.ArrayList;

public class StrassenMultiplication extends DivideAndConquerAlgorithm<int[][], int[][]> {
  public Boolean isSmall(int[][] matrix) {
    int n = matrix.length;
    return n <= 100;
  }

  public int[][] solveSmall(int[][] matrix) {
    int[][] result = new int[2][2];
    int[][] A = matrix;
    int[][] B = matrix;
    result[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
    result[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
    result[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
    result[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
    return result;
  }

  public ArrayList<int[][]> decompose(int[][] matrix, Integer size) {
    ArrayList<int[][]> subproblems = new ArrayList<>();
    int n = matrix.length;
    int mid = n / 2;

    int[][] A11 = new int[mid][mid];
    int[][] A12 = new int[mid][mid];
    int[][] A21 = new int[mid][mid];
    int[][] A22 = new int[mid][mid];
    int[][] B11 = new int[mid][mid];
    int[][] B12 = new int[mid][mid];
    int[][] B21 = new int[mid][mid];
    int[][] B22 = new int[mid][mid];

    for (int i = 0; i < mid; i++) {
      for (int j = 0; j < mid; j++) {
        A11[i][j] = matrix[i][j];
        A12[i][j] = matrix[i][j + mid];
        A21[i][j] = matrix[i + mid][j];
        A22[i][j] = matrix[i + mid][j + mid];

        B11[i][j] = matrix[i][j];
        B12[i][j] = matrix[i][j + mid];
        B21[i][j] = matrix[i + mid][j];
        B22[i][j] = matrix[i + mid][j + mid];
      }
    }

    subproblems.add(A11);
    subproblems.add(A12);
    subproblems.add(A21);
    subproblems.add(A22);
    subproblems.add(B11);
    subproblems.add(B12);
    subproblems.add(B21);
    subproblems.add(B22);

    return subproblems;
  }

  public int[][] combine(ArrayList<int[][]> solutions) {
    int[][] C11 = add(solutions.get(0), solutions.get(1));
    int[][] C12 = add(solutions.get(2), solutions.get(3));
    int[][] C21 = add(solutions.get(4), solutions.get(5));
    int[][] C22 = add(solutions.get(6), solutions.get(7));

    int n = C11.length * 2;
    int[][] C = new int[n][n];

    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n / 2; j++) {
        C[i][j] = C11[i][j];
        C[i][j + n / 2] = C12[i][j];
        C[i + n / 2][j] = C21[i][j];
        C[i + n / 2][j + n / 2] = C22[i][j];
      }
    }

    return C;
  }

  private int[][] add(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        C[i][j] = A[i][j] + B[i][j];
      }
    }
    return C;
  }

  public String getRecurrence() {
    return "T(n) = 7T(n/2) + O(n^2)";
  }
}
