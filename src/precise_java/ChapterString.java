/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/21
 */
public class ChapterString {

    public static int ecount(String s) {
        int ecount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                ecount++;
            }
        }
        return ecount;
    }

    public static boolean sorted(String[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (a[i - 1].compareTo(a[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(10 + 25 + "A");
        System.out.println("A" + 10 + 25);
        System.out.println("a".compareTo("A"));
        System.out.println(ecount("abcdeeee"));
        System.out.println(sorted(new String[]{"a", "b", "c", "d", "e"}));
        Point p1 = new Point(10, 20), p2 = new Point(30, 40);
        System.out.println("p1 is " + p1);
        System.out.println("p2 is " + p2);
        p2.move(7, 7);
        System.out.println("p2 is " + p2);
    }

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
        }

        public void move(int a, int b) {
            this.x += a;
            this.y += b;
        }
    }

}
