/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为机考;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */

public class AllPrime {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer val = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i * i <= val; i++) {
            if (val % i == 0) {
                sb.append(i).append(" ");
                val /= i;
                i--;
            }
        }
        sb.append(val).append(" ");
        System.out.println(sb);
        br.close();
    }
}