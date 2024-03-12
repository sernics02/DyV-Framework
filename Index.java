import java.util.Scanner;

public class Index {
  public void execute() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Seleccione una opción:");
    System.out.println("1. Modo normal");
    System.out.println("2. Modo debug");

    int modo = scanner.nextInt();

    switch (modo) {
      case 1:
        normalMode();
        break;
      case 2:
        debugMode();
        break;
      default:
        System.out.println("Opción inválida");
        break;
    }

    scanner.close();
  }
  public void normalMode() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Seleccione una opción:");
    System.out.println("1. Ordenación");
    System.out.println("2. BinarySearch");
    System.out.println("3. TorreHanoi");
    System.out.println("4. Strassen");
    System.out.println("5. Euclides");

    int option = scanner.nextInt();
    switch (option) {
      case 1:
        Ordenacion ordenacion = new Ordenacion();
        ordenacion.normalMode();
        break;
      case 2:
        Busqueda busqueda = new Busqueda();
        busqueda.normalMode();
        break;
      case 3:
        HanoiExecute torreHanoi = new HanoiExecute();
        torreHanoi.normalMode();
        break;
      case 4:
        Strassen strassen = new Strassen();
        strassen.normalMode();
        break;
      case 5:
        EuclidesExecute euclides = new EuclidesExecute();
        euclides.normalMode();
      default:
        System.out.println("Opción inválida");
        break;
    }
    scanner.close();
  }
  public void debugMode() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Seleccione una opción:");
    System.out.println("1. Ordenación");
    System.out.println("2. BinarySearch");
    System.out.println("3. TorreHanoi");
    System.out.println("4. Strassen");
    System.out.println("5. Euclides");

    int option = scanner.nextInt();
    switch (option) {
      case 1:
        Ordenacion ordenacion = new Ordenacion();
        ordenacion.debugMode();
        break;
      case 2:
        Busqueda busqueda = new Busqueda();
        busqueda.debugMode();
        break;
      case 3:
        HanoiExecute torreHanoi = new HanoiExecute();
        torreHanoi.debugMode();
        break;
      case 4:
        Strassen strassen = new Strassen();
        strassen.debugMode();
        break;
      case 5:
        EuclidesExecute euclides = new EuclidesExecute();
        euclides.debugMode();
        break;
      default:
        System.out.println("Opción inválida");
        break;
    }
    scanner.close();
  }

}
