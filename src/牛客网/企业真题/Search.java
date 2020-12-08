/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.企业真题;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
public class Search {

    public static void main(String[] args) {
        Search search = new Search();
        int[] A = {258, 260, 265, 266, 268, 269, 271, 275, 276, 278, 280, 282, 287, 288, 289, 293, 2, 4, 5, 9, 16, 23,
            24, 25, 26, 27, 28, 36, 37, 46, 47, 52, 55, 56, 60, 63, 67, 71, 74, 75, 76, 79, 80, 81, 82, 92, 97, 99, 103,
            104, 106, 109, 111, 112, 117, 121, 125, 131, 133, 136, 141, 142, 143, 144, 154, 160, 161, 168, 169, 179,
            187, 190, 201, 202, 204, 206, 208, 209, 211, 213, 218, 220, 222, 224, 225, 226, 229, 230, 231, 234, 240,
            241, 242, 243, 244, 245, 247, 249, 252, 253, 254, 257};
        System.out.println(search.search(A, 81));
    }

    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (A[mid] == target) {
                return mid;
            }
            if (A[left] <= A[mid] && (A[left] <= target && target < A[mid])) {
                right = mid - 1;
            } else if (A[mid] <= A[right] && !(A[mid] < target && target <= A[right])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
