package all_problems;

public class P1884_EggDropWith2EggsAndNFloors {
  public static int twoEggDrop(int n) {
    int count = 0;
    n += 1;
    while (n != 1) {
      count++;
      n /= 2;
    }
    return count * 2;
  }

  public static void main(String[] args) {
    System.out.println(twoEggDrop(2));
    System.out.println(twoEggDrop(100));
  }
}
