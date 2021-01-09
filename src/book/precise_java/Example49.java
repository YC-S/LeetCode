/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example49 {

    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        System.out.println(p1);
        Point p2 = p1;
        p2.move(10, 3);
        System.out.println(p2);
        System.out.println(p1);
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
