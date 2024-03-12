import java.util.ArrayList;

public class TorreHanoi extends DivideAndConquerAlgorithm<HanoiClass, Void> {

  private HanoiClass hanoi;

  public void Hanoi(int n, int origen, int auxiliar, int destino, int mode) {
    hanoi = new HanoiClass(origen, auxiliar, destino, n, mode);
    solve(hanoi, n);
  }

  @Override
  public Boolean isSmall(HanoiClass data) {
    return data.getSize() == 1;
  }

  @Override
  public Void solveSmall(HanoiClass data) {
    if (data.getMode() == 1) {
      System.out.println("Mover disco " + data.getOrigen());
    }
    return null;
  }

  @Override
  public ArrayList<HanoiClass> decompose(HanoiClass data, Integer size) {
    ArrayList<HanoiClass> subproblems = new ArrayList<>();
    subproblems.add(new HanoiClass(data.getSize() - 1, data.getOrigen(), data.getAuxiliar(), data.getDestino(), data.getMode()));
    subproblems.add(new HanoiClass(1, data.getOrigen(), data.getDestino(), data.getAuxiliar(), data.getMode()));
    subproblems.add(new HanoiClass(data.getSize() - 1, data.getAuxiliar(), data.getDestino(), data.getOrigen(), data.getMode()));
    return subproblems;
  }

  @Override
  public Void combine(ArrayList<Void> solutions) {
    return null;
  }

  @Override
  public String getRecurrence() {
    return "T(n) = 2T(n - 1) + 1";
  }
}
