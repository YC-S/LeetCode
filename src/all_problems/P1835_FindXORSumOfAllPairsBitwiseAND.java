package all_problems;

public class P1835_FindXORSumOfAllPairsBitwiseAND {
  public int getXORSum(int[] A, int[] B) {
    int xora = 0, xorb = 0;
    for (int a : A) xora ^= a;
    for (int b : B) xorb ^= b;
    return xora & xorb;
  }
}
