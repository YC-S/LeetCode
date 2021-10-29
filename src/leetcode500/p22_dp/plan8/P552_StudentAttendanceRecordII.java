package leetcode500.p22_dp.plan8;

public class P552_StudentAttendanceRecordII {
  public int checkRecord(int n) {
    long M = (long) (Math.pow(10, 9) + 7);
    long[] f = new long[n <= 5 ? 6 : n + 1];
    f[0] = 1;
    f[1] = 2;
    f[2] = 4;
    f[3] = 7;
    for (int i = 4; i <= n; i++) f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
    long sum = f[n];
    for (int i = 1; i <= n; i++) {
      sum += (f[i - 1] * f[n - i]) % M;
    }
    return (int) (sum % M);
  }
}
