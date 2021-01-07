package all_problems;

public class P479_LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        long max = (long) Math.pow(10, n) - 1;
        long min = max / 10;

        for (long h = max; h > min; h--) {
            long left = h, right = 0;
            for (long i = h; i != 0; right = right * 10 + i % 10, i /= 10, left *= 10) ;
            long palindrom = left + right;      // construct the palindrome

            for (long i = max; i > min; i--) {
                long j = palindrom / i;
                if (j > i) break;     // terminate if the other number is greater than current number
                if (palindrom % i == 0) return (int) (palindrom % 1337); // found if current number is a factor
            }
        }

        return 9;    // account for case n = 1
    }
}
