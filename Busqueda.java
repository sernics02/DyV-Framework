import java.util.ArrayList;
import java.util.Scanner;

public class Busqueda {
  public void normalMode() {
    DivideAndConquerAlgorithm<BinarySearch.SearchData, Integer> algorithm = new BinarySearch();
    System.out.println("Binary Search,");
    System.out.println("Tamaño, Tiempo,");
    for (int i = 1000; i <= 100000; i+= 1000)  {
      ArrayList<Integer> data = generateArray(i);
      data.sort(null);
      int target = (int) (Math.random() * i);
      target = data.get(target);
      BinarySearch.SearchData searchData = new BinarySearch.SearchData(data, target, 0, data.size() - 1);
      long startTime = System.currentTimeMillis();
      algorithm.modification(searchData, i);
      long endTime = System.currentTimeMillis();
      long time = endTime - startTime;
      System.out.println(i + ", " + time + ",");
    }
  }
  public void debugMode() {
    DivideAndConquerAlgorithm<BinarySearch.SearchData, Integer> algorithm = new BinarySearch();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el tamaño de la instancia:");
    int size = scanner.nextInt();
    ArrayList<Integer> data = generateArray(size);
    data.sort(null);
    int target = (int) (Math.random() * size);
    target = data.get(target);
    BinarySearch.SearchData searchData = new BinarySearch.SearchData(data, target, 0, data.size() - 1);
    
    System.out.println("Instancia: " + data);
    System.out.println("Objetivo: " + target);
    
    long startTime = System.currentTimeMillis();
    Integer solution = algorithm.modification(searchData, size);
    long endTime = System.currentTimeMillis();
    long time = endTime - startTime;
    
    System.out.println("Solución: " + solution);
    System.out.println("Tiempo: " + time + " ms");
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
