package all_problems;

public class P744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        if (target >= letters[n - 1]) target = letters[0];
        else target++;

        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] == target) return letters[mid];
            if (letters[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return letters[hi];
    }
}
