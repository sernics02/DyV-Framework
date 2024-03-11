import java.util.ArrayList;
import java.util.Scanner;

public class Ordenacion {
  public void normalMode() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleccione una opción:");
    System.out.println("1. Merge Sort");
    System.out.println("2. Quick Sort");

    int option = scanner.nextInt();
    DivideAndConquerAlgorithm<ArrayList<Integer>, ArrayList<Integer>> algorithm = null;
    switch (option) {
      case 1:
        algorithm = new MergeSort();
        System.out.println("Merge Sort:");
        break;
      case 2:
        algorithm = new QuickSort();
        System.out.println("Quick Sort:");
        break;
      default:
        break;
    }
    System.out.println("Tamaño, Tiempo,");
    for (int i = 1000; i <= 10000; i += 10) {
      ArrayList<Integer> data = generateArray(i);
      long startTime = System.currentTimeMillis();
      algorithm.modification(data, i);
      long endTime = System.currentTimeMillis();
      long time = endTime - startTime;
      System.out.println(i + ", " + time + ",");
    }
    scanner.close();
  }

  public void debugMode() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleccione una opción:");
    System.out.println("1. Merge Sort");
    System.out.println("2. Quick Sort");

    int option = scanner.nextInt();
    DivideAndConquerAlgorithm<ArrayList<Integer>, ArrayList<Integer>> algorithm = null;
    switch (option) {
      case 1:
        algorithm = new MergeSort();
        System.out.println("Merge Sort:\n");
        break;
      case 2:
        algorithm = new QuickSort();
        System.out.println("Quick Sort:\n");
        break;
      default:
        break;
    }

    System.out.println("Ingrese el tamaño de la instancia:");
    int size = scanner.nextInt();
    ArrayList<Integer> data = generateArray(size);

    System.out.println("Instancia generada:");
    System.out.println(data);

    System.out.println("Solución obtenida:");
    ArrayList<Integer> sorted = algorithm.modification(data, size);
    System.out.println(sorted);

    scanner.close();
  }
  
  public static ArrayList<Integer> generateArray(Integer size) {
    ArrayList<Integer> data = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      data.add((int) (Math.random() * size));
    }
    return data;
  }
}

