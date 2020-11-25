/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example52 {

    public static void main(String[] args) {
        Number n1 = new Integer(17);
        Number n2 = new Double(3.14);
        System.out.println(n1 instanceof Double);
        System.out.println(n2 instanceof Double);
        System.out.println(null instanceof Double);
        System.out.println(n2 instanceof Number);

    }

}
