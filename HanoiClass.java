public class HanoiClass {
  private int origen;
  private int auxiliar;
  private int destino;
  private int size;
  private int mode;

  public HanoiClass(int origen, int auxiliar, int destino, int size, int mode) {
    this.origen = origen;
    this.auxiliar = auxiliar;
    this.destino = destino;
    this.size = size;
    this.mode = mode;
  }

  public int getOrigen() {
    return origen;
  }

  public int getAuxiliar() {
    return auxiliar;
  }

  public int getDestino() {
    return destino;
  }

  public int getSize() {
    return size;
  }

  public int getMode() {
    return mode;
  }
}