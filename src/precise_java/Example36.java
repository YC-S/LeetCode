/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example36 {

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        System.out.println(p1);
    }

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point p) {
            this(p.x, p.y);
        }

        public void move(int dx, int dy) {
            x += dx;
            y += dy;
        }

        @Override
        public String toString() {
            return "Point(" +
                "x=" + x +
                ", y=" + y +
                ')';
        }
    }
}
