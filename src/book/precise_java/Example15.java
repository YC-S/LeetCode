/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

import java.util.Date;
import java.util.Locale;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/21
 */
public class Example15 {

    public static void main(String[] args) {
        Date now = new Date();
        System.out.format("%tc%n", now);
        System.out.format(Locale.US, "%tc%n", now);
        System.out.format(Locale.CHINA, "%tc%n", now);
        System.out.format(Locale.JAPAN, "%tc%n", now);
        System.out.format(Locale.KOREA, "%tc%n", now);
        System.out.format(Locale.TAIWAN, "%tc%n", now);
        System.out.format(Locale.GERMANY, "%tc%n", now);
        System.out.format(Locale.FRANCE, "%tc%n", now);
        System.out.format(Locale.ITALY, "%tc%n", now);
    }
}
