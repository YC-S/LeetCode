/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example24 {

    public static void main(String[] args) {
        Point a = new Point(1, 1);
        a.move(1, 1);
        System.out.println(a);
    }

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move(int dx, int dy) {
            x += dx;
            y += dy;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

}
