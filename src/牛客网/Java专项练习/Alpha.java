/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.Java专项练习;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
class Base {

    Base() {
        System.out.println("Base");
    }
}

public class Alpha extends Base {

    public static void main(String[] args) {
        new Alpha();
        new Base();
    }

}
