/*
 * Copyright (c) 2020. Yuanchen
 */

package google;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/10/13
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(3 / 0);
        } catch (RuntimeException r) {
            System.out.println(r);
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                System.out.println(e);
            }
        } finally {
            System.out.println("finally");
        }
    }
}
