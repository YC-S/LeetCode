package all_problems;

public class P421_MaximumXOROfTwoNumbersInAnArray {
    private final boolean ZERO = false;
    private final boolean ONE = true;

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode(31, ZERO);
        for (int i = 0; i < nums.length; i++) {
            insert(root, nums[i]);
        }

        return maxXORTrieNode(root, root);
    }

    private void insert(TrieNode node, int num) {
        TrieNode tmp = node;
        int index = 1 << 30;
        while (index > 0) {
            if ((num & index) > 0) {
                if (tmp.oneChild == null) {
                    tmp.oneChild = new TrieNode(tmp.level - 1, ONE);
                }
                tmp = tmp.oneChild;
            } else {
                if (tmp.zeroChild == null) {
                    tmp.zeroChild = new TrieNode(tmp.level - 1, ZERO);
                }
                tmp = tmp.zeroChild;
            }
            index = index >> 1;
        }
    }

    private int maxXORTrieNode(TrieNode left, TrieNode right) {
        if (left == null || right == null) {
            return 0;
        }
        int res = Math.max(maxXORTrieNode(left.zeroChild, right.oneChild), maxXORTrieNode(left.oneChild, right.zeroChild));
        if (res == 0) {
            res = Math.max(maxXORTrieNode(left.zeroChild, right.zeroChild), maxXORTrieNode(left.oneChild, right.oneChild));
        }
        return res + (left.isOne == right.isOne ? 0 : 1 << left.level);
    }

    private static class TrieNode {
        int level;
        boolean isOne;
        TrieNode zeroChild;
        TrieNode oneChild;

        TrieNode(int level, boolean isOne) {
            this.level = level;
            this.isOne = isOne;
        }
    }
}
