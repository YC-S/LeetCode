package book.Algorithms.chapter1.section1;

public class P1_1_17 {
    public static String exR2(int n) {
        if (n <= 0) return "";
        return exR2(n - 3) + n + exR2(n - 2) + n;
    }

    public static void main(String[] args) {
        System.out.println(exR2(6));
    }
}
