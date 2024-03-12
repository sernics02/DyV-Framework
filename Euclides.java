import java.util.ArrayList;

public class Euclides extends DivideAndConquerAlgorithm<PairNumbers, Integer> {
  @Override
  public Boolean isSmall(PairNumbers data) {
    return data.getB() == data.getA();
  }
  @Override
  public Integer solveSmall(PairNumbers data) {
    return data.getA();
  }
  @Override
  public ArrayList<PairNumbers> decompose(PairNumbers data, Integer size) {
    ArrayList<PairNumbers> subproblems = new ArrayList<PairNumbers>();
    if (data.getA() > data.getB()) {
      subproblems.add(new PairNumbers(data.getA() - data.getB(), data.getB()));
    } else {
      subproblems.add(new PairNumbers(data.getA(), data.getB() - data.getA()));
    }
    return subproblems;
  }
  @Override
  public Integer combine(ArrayList<Integer> solutions) {
    return solutions.get(0);
  }
  @Override
  public String getRecurrence() {
    return "T(n) = T(n-1) + 1";
  }
}