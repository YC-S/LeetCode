package all_problems;

public class P1256_EncodeNumber {
    public String encode(int num) {
        return num > 0 ? encode((num - 1) / 2) + "10".charAt(num % 2) : "";
    }
}
