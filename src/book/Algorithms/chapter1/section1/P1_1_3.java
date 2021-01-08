package book.Algorithms.chapter1.section1;

public class P1_1_3 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        System.out.println(arr[0] == arr[1] && arr[1] == arr[2]);
    }
}
