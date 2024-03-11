import java.util.ArrayList;
import java.util.Scanner;
public class Index {
  public void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Seleccione una opción:");
    System.out.println("1. Ordenación");
    System.out.println("2. BinarySearch");
    System.out.println("3. TorreHanoi");
    System.out.println("4. Strassen");
    
    int opcion = scanner.nextInt();
    int numValues = 0;
    ArrayList<Integer> data = new ArrayList<Integer>();
    if (opcion == 2 || opcion == 3) {
      System.out.println("Ingrese el número de elementos: ");
      numValues = scanner.nextInt();
      for (int i = 0; i < numValues; i++) {
        data.add((int) (Math.random() * 100));
      }
    }

    switch (opcion) {
      case 1:
        Ordenacion ordenacion = new Ordenacion();
        ordenacion.ordenar();
        break;
      case 2:
        BinarySearch binarySearch = new BinarySearch();
        Integer target = (int) (Math.random() * numValues);
        target = data.get(target);
        System.out.println(target + ": " + data);
        Integer index = binarySearch.modification(new BinarySearch.SearchData(data, target, 0, data.size() - 1), data.size());
        System.out.println("El índice del elemento " + target + " es: " + index);
        break;
      case 3:
        TorreHanoi torreHanoi = new TorreHanoi();
        torreHanoi.Hanoi(numValues, 1, 2, 3);
        break;
      case 4:
        int size = 4;
        Matrix a = generateMatrix(size, size);
        Matrix b = generateMatrix(size, size);
        TwoMatrix twoMatrix = new TwoMatrix(a, b);
        Strassen strassen = new Strassen();
        Matrix c = strassen.solve(twoMatrix, size);
        c.print();
        break;
      default:
        System.out.println("Opción inválida");
        break;
    }
    
    scanner.close();
  }
  public static Matrix generateMatrix(int rows, int columns) {
    int[][] data = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        data[i][j] = (int) (Math.random() * 100);
      }
    }
    return new Matrix(data);
  }
}
