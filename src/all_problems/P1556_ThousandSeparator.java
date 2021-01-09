package all_problems;

public class P1556_ThousandSeparator {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        while (n > 0) {
            int rem = n % 10;
            n /= 10;
            count++;

            sb.append(rem);
            if (n > 0 && count == 3) {
                sb.append(".");
                count = 0;
            }
        }
        if (sb.length() == 0)
            return "0";
        return sb.reverse().toString();
    }
}
