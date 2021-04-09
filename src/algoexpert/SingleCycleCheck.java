package algoexpert;

public class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int visited = 0;
        int curIndex = 0;
        while (visited < array.length) {
            if (visited > 0 && curIndex == 0) return false;
            curIndex = getIndex(array, curIndex + array[curIndex]);
            visited++;
        }
        return curIndex == 0;
    }

    private static int getIndex(int[] array, int index) {
        index = index % array.length;
        return index >= 0 ? index : index + array.length;
    }

    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[]{2, 3, 1, -4, -4, 2}));
    }
}
