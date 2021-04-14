package company.others.expedia;

public class FindTheFactor {
    public static long nthUglyNumber(long n, long p) {
        long i = 1;
        for (; i * i <= n; i++)
            if (n % i == 0 && --p == 0)
                return i;
        i = i - 1;
        if (i * i == n)
            i = i - 1;
        for (; i >= 1; i--) {
            if (n % i == 0 && --p == 0)
                return n / i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10, 3));
    }
}
