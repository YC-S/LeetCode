package all_problems;

import java.util.Arrays;

public class P1196_HowManyApplesCanYouPutIntoTheBasket {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int left = 5000;
        int i = 0;
        for (; i < arr.length && left - arr[i] >= 0; i++) {
            left -= arr[i];
        }
        return i;
    }
}
