/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

public class Types {

    public static void main(String[] args) {
        int a, b, c;
        int x = 1, y = 2, z = 3;
        int ratio = z / x;
        final double PI = 3.141592653589;
        boolean found = false;
        final int maxyz;
        if (z > y) {
            maxyz = z;
        } else {
            maxyz = y;
        }
        System.out.println("ratio=" + ratio);
        System.out.println("PI=" + PI);
        System.out.println("maxyz=" + maxyz);
    }
}
