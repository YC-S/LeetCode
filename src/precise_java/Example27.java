/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example27 {

    public static void main(String[] args) {
        Vessel v1 = new Barrel(3, 10);
        Vessel v2 = new Tank(10, 20, 12);
        Vessel v3 = new Cube(4);
        Vessel[] vs = {v1, v2, v3};
        v1.fill(90);
        v1.fill(10);
        v2.fill(100);
        v3.fill(80);
        double sum = 0;
        for (Vessel v : vs) {
            sum += v.capacity();
        }
        System.out.println("Total capacity is " + sum);
        for (int i = 0; i < vs.length; i++) {
            System.out.println("vessel number " + i + ": " + vs[i]);
        }
    }

    abstract static class Vessel {

        double contents;

        /**
         * the capacity of the vessel.
         */
        abstract double capacity();

        void fill(double amount) {
            contents = Math.min(contents + amount, capacity());
        }
    }

    static class Tank extends Vessel {

        double length, width, height;

        Tank(double length, double width, double height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        @Override
        double capacity() {
            return length * width * height;
        }

        @Override
        public String toString() {
            return "Tank (" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ')';
        }
    }

    static class Cube extends Tank {

        Cube(double side) {
            super(side, side, side);
        }

        @Override
        public String toString() {
            return "Cube(" +
                "length=" + length +
                ')';
        }
    }

    static class Barrel extends Vessel {

        double radius, height;

        public Barrel(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }

        /**
         * the capacity of the vessel.
         */
        @Override
        double capacity() {
            return height * Math.PI * radius * radius;
        }

        @Override
        public String toString() {
            return "Barrel(" +
                "radius=" + radius +
                ", height=" + height +
                ')';
        }
    }
}
