/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

import java.util.ArrayList;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example25 {

    public static void main(String[] args) {
        SPoint sPoint = new SPoint(1, 1);
        System.out.println(SPoint.getSize());
        System.out.println(SPoint.getPoint(0));
        sPoint.move(1, 1);
        System.out.println(sPoint);
        System.out.println(sPoint.getIndex());
    }

    static class SPoint {

        static ArrayList<SPoint> allpoints = new ArrayList<>();
        int x, y;

        SPoint(int x, int y) {
            allpoints.add(this);
            this.x = x;
            this.y = y;
        }

        static int getSize() {
            return allpoints.size();
        }

        static SPoint getPoint(int i) {
            return allpoints.get(i);
        }

        void move(int dx, int dy) {
            x += dx;
            y += dy;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        int getIndex() {
            return allpoints.indexOf(this);
        }
    }

}
