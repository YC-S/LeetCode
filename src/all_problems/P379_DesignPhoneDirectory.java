package all_problems;

public class P379_DesignPhoneDirectory {
    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    int[] next;
    int pos;

    public P379_DesignPhoneDirectory(int maxNumbers) {
        next = new int[maxNumbers];
        for (int i = 0; i < maxNumbers; ++i) {
            next[i] = (i + 1) % maxNumbers;
        }
        pos = 0;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (next[pos] == -1) return -1;
        int ret = pos;
        pos = next[pos];
        next[ret] = -1;
        return ret;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return next[number] != -1;
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (next[number] != -1) return;
        next[number] = pos;
        pos = number;
    }
}
