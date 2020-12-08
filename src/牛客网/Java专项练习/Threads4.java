/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.Java专项练习;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
public class Threads4 {

    public static void main(String[] args) {
        new Threads4().go();
    }

    public void go() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

}
