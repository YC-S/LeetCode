/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为机考;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class BeautifulWord {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String value;
        while ((value = bf.readLine()) != null) {
            int num = Integer.parseInt(value);
            for (int index = 0; index < num; index++) {
                String name = bf.readLine();
                char[] nameChars = name.toCharArray();
                int[] charMaxs = new int[150];
                for (int inda = 0; inda < nameChars.length; inda++) {
                    charMaxs[nameChars[inda]]++;
                }
                Arrays.sort(charMaxs);
                int max = 26;
                int total = 0;
                for (int indb = charMaxs.length - 1; indb >= 0; indb--) {
                    if (charMaxs[indb] == 0) {
                        break;
                    }
                    total = total + charMaxs[indb] * max;
                    max--;
                }
                System.out.println(total);
            }
        }
    }
}
