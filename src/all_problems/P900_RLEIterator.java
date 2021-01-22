package all_problems;

public class P900_RLEIterator {
    int index;
    int[] A;

    public P900_RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }

    public int next(int n) {
        while (index < A.length && n > A[index]) {
            n = n - A[index];
            index += 2;
        }

        if (index >= A.length) {
            return -1;
        }

        A[index] = A[index] - n;
        return A[index + 1];
    }
}
