package all_problems;

public class P4_MedianOfTwoSortedArrays {

    // find kth number of two sorted data_structures.array
    public static int findKth(int[] A, int startOfA,
                              int[] B, int startOfB,
                              int k) {
        if (startOfA >= A.length) {
            return B[startOfB + k - 1];
        }
        if (startOfB >= B.length) {
            return A[startOfA + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }

        int halfKthOfA = startOfA + k / 2 - 1 < A.length
                ? A[startOfA + k / 2 - 1]
                : Integer.MAX_VALUE;
        int halfKthOfB = startOfB + k / 2 - 1 < B.length
                ? B[startOfB + k / 2 - 1]
                : Integer.MAX_VALUE;

        if (halfKthOfA < halfKthOfB) {
            return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
        } else {
            return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
        }
    }

    /**
     * 归并 解题思路 最简单的思路是将两个数组合并，然后返回新数组的中位数。两个有序数组的合并也是经典归并排序算法的一步，我们可以新开一 个数组，保存合并后的结果。但是我们这样会做额外的工作，因为我们不必保存整个新数组，只需要知道新数组的中位数即可。
     * 因此，更简便的方法是，使用双指针分别对两个数组遍历，比较两个指针下的元素大小，每次移动更小的指针，通过移动次数确定中位数的位置。 算法流程 令指针p1和p2分别指向两个数组，初始指向位置0。我们需要遍历(m + n)/2 +
     * 1次，每次比较两个位置的元素，在第k次比较时，较小的那个值就是两个数组中第k + 1小的数。如果一个指针已经走到了数组末尾，那么移动 另一个指针，否则每次将指向较小数的指针后移，直到遍历到中位数。
     * 为了将奇偶情况合并，在代码中用了left和right保存中间值，如果是奇数直接返回right，如果是偶数就返回(left + right) / 2。
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length + B.length;

        if (n % 2 == 0) {
            return (
                    findKth(A, 0, B, 0, n / 2) +
                            findKth(A, 0, B, 0, n / 2 + 1)
            ) / 2.0;
        }

        return findKth(A, 0, B, 0, n / 2 + 1);
    }
}
