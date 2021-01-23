package all_problems;

public class P1157_OnlineMajorityElementInSubarray {
    int[] arr;

    public P1157_OnlineMajorityElementInSubarray(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        int vote = -1;
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (cnt == 0) {
                vote = arr[i];
            }
            if (vote == arr[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == vote) {
                cnt++;
            }
        }
        return cnt >= threshold ? vote : -1;
    }

}
