package leetcode500.p27_segment_tree.plan1;

public class P307_RangeSumQuery_Mutable {

  private int N;
  private int[] tree;

  public P307_RangeSumQuery_Mutable(int[] nums) {
    if (nums != null && nums.length != 0) {
      this.N = nums.length;
      this.tree = new int[(N << 1)];
      int i;

      for (i = 0; i < N; i++) {
        this.tree[N + i] = nums[i];
      }

      for (i = N - 1; i >= 0; i--) {
        this.tree[i] = this.tree[i << 1] + this.tree[(i << 1) + 1];
      }
    }
  }

  public void update(int index, int val) {
    int treeIndex = this.N + index;
    if (this.tree[treeIndex] != val) { // mark this important step - update only if needed
      this.tree[treeIndex] = val;

      while (treeIndex != 0) {
        treeIndex = (treeIndex >> 1);
        this.tree[treeIndex] = this.tree[treeIndex << 1] + this.tree[(treeIndex << 1) + 1];
      }
    }
  }

  public int sumRange(int left, int right) {
    int leftIndex = left + this.N;
    int rightIndex = right + this.N;
    int sum = 0;

    while (leftIndex <= rightIndex) {
      if ((leftIndex & 1) == 1) {
        sum = sum + this.tree[leftIndex];
        ++leftIndex;
      }

      if ((rightIndex & 1) == 0) {
        sum = sum + this.tree[rightIndex];
        --rightIndex;
      }

      leftIndex = (leftIndex >> 1);
      rightIndex = (rightIndex >> 1);
    }

    return sum;
  }
}
