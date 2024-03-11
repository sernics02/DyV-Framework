import java.util.ArrayList;

public class TorreHanoi extends DivideAndConquerAlgorithm<Integer, Void> {
  Integer origen;
  Integer auxiliar;
  Integer destino;
  private Integer mode;
  public void Hanoi(int n, int origen,  int auxiliar, int destino, int mode){
    this.origen = origen;
    this.auxiliar = auxiliar;
    this.destino = destino;
    this.mode = mode;

    modification(n, n, 0, 0);
  }
  @Override
  public Boolean isSmall(Integer data) {
    return data == 1;
  }
  @Override
  public Void solveSmall(Integer data) {
    if (this.mode == 1) {
      System.out.println("mover disco de " + origen + " a " + destino);
    }
    return null;
  }
  @Override
  public ArrayList<Integer> decompose(Integer data, Integer size) {
    ArrayList<Integer> subproblems = new ArrayList<Integer>();
    subproblems.add(data - 1);
    subproblems.add(data - 1);
    return subproblems;
  }
  @Override
  public Void combine(ArrayList<Void> solutions) {
    return null;
  }
  @Override
  public String getRecurrence() {
    return "2T(n-1) + O(1)";
  }
}
