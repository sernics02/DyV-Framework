import java.util.Scanner;

public class Strassen {
  public void normalMode() {
    DivideAndConquerAlgorithm<int[][], int[][]> algorithm = new StrassenMultiplication();
    System.out.println("Tamaño,Strassen,Multiplicación Típica");
    for (int i = 2; i <= 2048; i *= 2)  {
      int[][] data = generateMatrix(i, i);
      long startTime = System.currentTimeMillis();
      algorithm.modification(data, i);
      long endTime = System.currentTimeMillis();
      long strassenTime = endTime - startTime;

      startTime = System.currentTimeMillis();
      multiply(data, data);
      endTime = System.currentTimeMillis();
      long multiplyTime = endTime - startTime;
      System.out.println(i + "," + strassenTime + "," + multiplyTime + ",");
    }
  }
  public void debugMode() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el tamaño de la matriz:");
    int size = scanner.nextInt();
    DivideAndConquerAlgorithm<int[][], int[][]> algorithm = new StrassenMultiplication();
    int[][] data = generateMatrix(size, size);
    System.out.println("Matriz generada:");
    printMatrix(data);
    int[][] solution = algorithm.modification(data, size);
    System.out.println("Resultado de la multiplicación de matrices:");
    printMatrix(solution);
    scanner.close();
  }
  public int[][] generateMatrix(int rows, int cols) {
    int[][] matrix = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = (int) (Math.random() * 10);
      }
    }
    return matrix;
  }
  public void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
  public int[][] multiply(int[][] matrix1, int[][] matrix2) {
    int n = matrix1.length;
    int[][] result = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          result[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    return result;
  }
}
