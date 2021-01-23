package all_problems;

public class P1151_MinimumSwapsToGroupAll1sTogether {
    public int minSwaps(int[] data) {
        if (data.length < 3) return 0;
        int n = 0;
        for (int num : data) {
            if (num == 1) n++; // total number of 1s
        }
        int i = 0, j = 0, c = 0, max = 0; //sliding window i to j
        while (j < data.length) {
            while (j < data.length && j - i < n) { //until i to j == n or search is done
                if (data[j++] == 1) c++;
            }
            max = Math.max(c, max); // max all the sliding window of which length equals to n
            if (j == data.length) break;

            if (data[i++] == 1) { //move i forward
                c--;
            }
        }
        return n - max; //this is the minimun swaps
    }
}
