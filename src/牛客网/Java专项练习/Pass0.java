/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.Java专项练习;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
class Two {

    Byte x;
}

public class Pass0 {

    public static void main(String[] args) {
        Pass0 p = new Pass0();
        p.start();
        System.out.println(5 + ~(10));
    }

    void start() {
        Two t = new Two();
        System.out.print(t.x + " ");
        Two t2 = fix(t);
        System.out.print(t.x + " " + t2.x);
    }

    Two fix(Two tt) {
        tt.x = 42;
        return tt;
    }
}
