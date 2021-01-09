/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

import java.util.Random;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/21
 */
public class Example14 {

    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 5; ++j) {
                System.out.format("%,15d", rnd.nextInt(1000000000));
            }
            System.out.format("%n");
        }
    }
}
