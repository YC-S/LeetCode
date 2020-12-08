/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.Java专项练习;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
public class Test2 {

    private static int i = 1;

    public static void main(String[] args) {
        Test2 test = new Test2();
        Test2 testObject = new Test2();
        test.getNext();
        testObject.getNext();
        System.out.println(testObject.getNext());
        System.out.println(13 & 17);
    }

    public int getNext() {
        return i++;
    }
}
