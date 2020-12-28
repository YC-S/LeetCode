package contest.leetcode.双周赛._b_42;

public class Q2 {
    public static double averageWaitingTime(int[][] customers) {
        int prevEndTime = customers[0][1] + customers[0][0];
        double sum = customers[0][1];
        for (int i = 1; i < customers.length; ++i) {
            if (prevEndTime <= customers[i][0]) {
                sum += customers[i][1];
                prevEndTime = customers[i][0] + customers[i][1];
            } else {
                sum += prevEndTime - customers[i][0] + customers[i][1];
                prevEndTime += customers[i][1];
            }
        }
        return Double.parseDouble(String.format("%.5f", (sum / customers.length)));
    }

    public static void main(String[] args) {
        int[][] customers = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(customers));
    }
}
