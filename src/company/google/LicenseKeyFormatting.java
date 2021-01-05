/*
 * Copyright (c) 2020. Yuanchen
 */

package company.google;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/11
 */
public class LicenseKeyFormatting {

    public static void main(String[] args) {
        LicenseKeyFormatting solution = new LicenseKeyFormatting();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2));
    }

    // You are given a license key represented as a string S which consists only alphanumeric character and dashes.
    // The string is separated into N+1 groups by N dashes.
    //
    // Given a number K, we would want to reformat the data_structures.strings such that each group contains exactly K characters,
    // except for the first group which could be shorter than K, but still must contain at least one character.
    // Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to
    // uppercase.
    //
    // Given a non-empty string S and a number K, format the string according to the rules described above.
    // input: S = "5F3Z-2e-9-w", K = 4
    // output: "5F3Z-2E9W"
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '-') {
                if ('a' <= c && c <= 'z') {
                    sb.append((char) (c + 'A' - 'a'));
                } else {
                    sb.append(c);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int remainder = sb.length() % K;
        if (remainder == 0) {
            for (int i = 0; i < sb.length(); i++) {
                if (i % K == 0 && i != 0) {
                    res.append('-');
                }
                res.append(sb.charAt(i));

            }
        } else {
            for (int i = 0; i < remainder; i++) {
                res.append(sb.charAt(i));
            }
            for (int i = remainder; i < sb.length(); i++) {
                if ((i - remainder) % K == 0) {
                    res.append('-');
                }
                res.append(sb.charAt(i));
            }
        }
        return res.toString();
    }

}
