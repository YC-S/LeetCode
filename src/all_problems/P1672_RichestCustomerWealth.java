package all_problems;

public class P1672_RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
