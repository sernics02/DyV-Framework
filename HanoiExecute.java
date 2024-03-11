import java.util.Scanner;

public class HanoiExecute {
  public void normalMode() {
    System.out.println("Hanoi,");
    System.out.println("Discos, Tiempo,");
    for (int i = 1; i <= 30; i++) {
      TorreHanoi hanoi = new TorreHanoi();
      long startTime = System.currentTimeMillis();
      hanoi.Hanoi(i, 1, 2, 3, 0);
      long endTime = System.currentTimeMillis();
      long time = endTime - startTime;
      System.out.println(i + ", " + time + ",");
    }
  }
  public void debugMode() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el número de discos: ");
    int i = scanner.nextInt();
    TorreHanoi hanoi = new TorreHanoi();
    long startTime = System.currentTimeMillis();
    hanoi.Hanoi(i, 1, 2, 3, 1);
    long endTime = System.currentTimeMillis();
    long time = endTime - startTime;
    System.out.println(i + ", " + time + ",");
    scanner.close();
  }
}
