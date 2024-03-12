import java.util.Scanner;

public class EuclidesExecute {
  public void normalMode() {
    DivideAndConquerAlgorithm<PairNumbers, Integer> euclides = new Euclides();
    System.out.println("Euclides,");
    for (int i = 10; i < 100; i += 10) {
      for (int j = 5; j < 100; j += 10) {
        PairNumbers data = new PairNumbers(i, j);
        long startTime = System.currentTimeMillis();
        Integer result = euclides.modification(data, 0);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println(i + ", " + j + ", " + result + ", " + time);
      }
    }
  }
  public void debugMode() { 
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el valor de a: ");
    int a = scanner.nextInt();
    System.out.println("Ingrese el valor de b: ");
    int b = scanner.nextInt();
    PairNumbers data = new PairNumbers(a, b);
    DivideAndConquerAlgorithm<PairNumbers, Integer> euclides = new Euclides();
    Integer result = euclides.modification(data, 1);
    System.out.println("El máximo común divisor de " + a + " y " + b + " es " + result);
    scanner.close();
  }
}
