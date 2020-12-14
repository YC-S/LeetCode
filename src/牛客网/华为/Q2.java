/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(";");
        double a11 = Double.parseDouble(array[0].split(",")[0]);
        double a12 = Double.parseDouble(array[0].split(",")[1]);
        double a13 = Double.parseDouble(array[0].split(",")[2]);
        double a14 = Double.parseDouble(array[0].split(",")[3]);
        double a15 = Double.parseDouble(array[0].split(",")[4]);

        double a21 = Double.parseDouble(array[1].split(",")[0]);
        double a22 = Double.parseDouble(array[1].split(",")[1]);
        double a23 = Double.parseDouble(array[1].split(",")[2]);
        double a24 = Double.parseDouble(array[1].split(",")[3]);
        double a25 = Double.parseDouble(array[1].split(",")[4]);

        double a31 = Double.parseDouble(array[2].split(",")[0]);
        double a32 = Double.parseDouble(array[2].split(",")[1]);
        double a33 = Double.parseDouble(array[2].split(",")[2]);
        double a34 = Double.parseDouble(array[2].split(",")[3]);
        double a35 = Double.parseDouble(array[2].split(",")[4]);

        int x1 = Integer.parseInt(array[3].split(",")[0]);
        int x2 = Integer.parseInt(array[3].split(",")[1]);
        int x3 = Integer.parseInt(array[3].split(",")[2]);
        int x4 = Integer.parseInt(array[3].split(",")[3]);
        int x5 = Integer.parseInt(array[3].split(",")[4]);

        double b1 = Double.parseDouble(array[4].split(",")[0]);
        double b2 = Double.parseDouble(array[4].split(",")[1]);
        double b3 = Double.parseDouble(array[4].split(",")[2]);

        String c1 = array[5].split(",")[0];
        String c2 = array[5].split(",")[1];
        String c3 = array[5].split(",")[2];

        boolean check = true;
        double v1 = a11 * x1 + a12 * x2 + a13 * x3 + a14 * 4 + a15 * 5;
        double v2 = a21 * x1 + a22 * x2 + a23 * x3 + a24 * 4 + a25 * 5;
        double v3 = a31 * x1 + a32 * x2 + a33 * x3 + a34 * 4 + a35 * 5;
        if (c1.equals("<")) {
            if (v1 >= b1) {
                check = false;
            }
        } else if (c1.equals("=")) {
            if (v1 != b1) {
                check = false;
            }
        } else if (c1.equals(">")) {
            if (v1 < b1) {
                check = false;
            }
        } else if (c1.equals("<=")) {
            if (v1 > b1) {
                check = false;
            }
        } else if (c1.equals(">=")) {
            if (v1 < b1) {
                check = false;
            }
        }

        if (c2.equals("<")) {
            if (v2 >= b2) {
                check = false;
            }
        } else if (c2.equals("=")) {
            if (v2 != b2) {
                check = false;
            }
        } else if (c2.equals(">")) {
            if (v2 <= b2) {
                check = false;
            }
        } else if (c2.equals("<=")) {
            if (v2 > b2) {
                check = false;
            }
        } else if (c2.equals(">=")) {
            if (v2 < b2) {
                check = false;
            }
        }

        if (c3.equals("<")) {
            if (v3 >= b3) {
                check = false;
            }
        } else if (c3.equals("=")) {
            if (v3 != b3) {
                check = false;
            }
        } else if (c3.equals(">")) {
            if (v3 <= b3) {
                check = false;
            }
        } else if (c3.equals("<=")) {
            if (v3 > b3) {
                check = false;
            }
        } else if (c3.equals(">=")) {
            if (v3 < b3) {
                check = false;
            }
        }

        double max = Math.max(Math.max((v1 - b1), (v2 - b2)), (v3 - b3));
        System.out.println(check + " " + max);
    }
}
