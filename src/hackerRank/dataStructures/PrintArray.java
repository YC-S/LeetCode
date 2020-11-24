/*
 * Copyright (c) 2020. Yuanchen
 */

package hackerRank.dataStructures;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class PrintArray {

    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] a1 = {1, 2, 3};
        Integer[] a2 = {4, 5, 6};
        printArray(a1);
    }
}
