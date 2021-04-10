package algoexpert;

public class NumberOfWaysToTraverseGraph {
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        if (width == 1 || height == 1) {
            return 1;
        }
        return numberOfWaysToTraverseGraph(width - 1, height) + numberOfWaysToTraverseGraph(width, height - 1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(4, 3));
    }
}
