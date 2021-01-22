package all_problems;

public class P927_ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int numOne = 0;
        for (int i : arr) {
            if (i == 1) numOne++;
        }

        int[] noRes = {-1, -1};
        if (numOne == 0) return new int[]{0, 2};
        if (numOne % 3 != 0) return noRes;

        //find index of starting 1 of third string
        int idxThird = 0;
        int temp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                temp++;
                if (temp == numOne / 3) {
                    idxThird = i;
                    break;
                }
            }
        }

        int res1 = findEndIdx(arr, 0, idxThird);
        if (res1 < 0) return noRes;

        int res2 = findEndIdx(arr, res1 + 1, idxThird);
        if (res2 < 0) return noRes;

        return new int[]{res1, res2 + 1};
    }

    //right is the pattern to compare to.
    //return EndIdx of left pattern that matches right side.
    private int findEndIdx(int[] A, int left, int right) {
        while (A[left] == 0) left++;
        while (right < A.length) {
            if (A[left] != A[right]) return -1;
            left++;
            right++;
        }
        return left - 1;
    }
}
