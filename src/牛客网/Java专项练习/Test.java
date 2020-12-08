/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.Java专项练习;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
public class Test {

    public static void main(String[] args) {
        String s = "tommy";
        Object o = s;
        sayHello(o); //语句1
        sayHello(s); //语句2
    }

    public static void sayHello(String to) {
        System.out.println(String.format("Hello, %s", to));
    }

    public static void sayHello(Object to) {
        System.out.println(String.format("Welcome, %s", to));
    }

}
