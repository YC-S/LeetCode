/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example65 {

    static String findCountry(int prefix) {
        switch (prefix) {
            case 1:
                return "North America";
            case 44:
                return "Great Britain";
            case 45:
                return "Denmark";
            case 299:
                return "Greenland";
            case 46:
                return "Sweden";
            case 7:
                return "Russia";
            case 972:
                return "Israel";
            default:
                return "Unknown";
        }
    }

    public static void main(String[] args) {
        System.out.println(findCountry(1));
        System.out.println(findCountry(44));
        System.out.println(findCountry(45));
        System.out.println(findCountry(46));
        System.out.println(findCountry(7));
        System.out.println(findCountry(299));
        System.out.println(findCountry(972));
    }

}
