import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Ordenacion ordenacion = new Ordenacion();
    ordenacion.ordenar();

    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el número de elementos para la torre de Hanoi: ");
    int numDisks = scanner.nextInt();
    scanner.close();
    TorreHanoi torreHanoi = new TorreHanoi();
    System.out.println("La solución de la torre de Hanoi para " + numDisks + " discos es:");
    torreHanoi.Hanoi(numDisks, 1, 2, 3);
  }
}
