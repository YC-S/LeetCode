package book.Algorithms.chapter1.section1;

public class P1_1_18 {
    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static void main(String[] args) {
        System.out.println(mystery(10, 10));
    }
}
