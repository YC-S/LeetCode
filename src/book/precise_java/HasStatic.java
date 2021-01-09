/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/20
 */
public class HasStatic {

    public static int aMethod(int i) throws Exception {
        try {
            return i / 10;
        } catch (Exception ex) {
            throw new Exception("exception in a Method");
        } finally {
            System.out.printf("finally");
        }
    }

    public static void main(String[] args) {
        try {
            aMethod(0);
        } catch (Exception ex) {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }

}
