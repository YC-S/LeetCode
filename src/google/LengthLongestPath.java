/*
 * Copyright (c) 2020. Yuanchen
 */

package google;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/11
 */
public class LengthLongestPath {

    public static void main(String[] args) {
        LengthLongestPath solution = new LengthLongestPath();
//        System.out.println(solution.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
        System.out.println(solution.lengthLongestPath(
            "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public int lengthLongestPath(String input) {
        // Suppose we have a file system that stores both files and directories. An example of one system is represented
        // in the following picture:
        // Here, we have dir as the only directory in the root. dir contains two subdirectories, subdir1 and subdir2.
        // subdir1 contains a file file1.ext and subdirectory subsubdir1.
        // subdir2 contains a subdirectory subsubdir2, which contains a file file2.ext.
        // In text form, it looks like this (with ⟶ representing the tab character)
        // no dir
        if (!input.contains("\t")) {
            String[] arr = input.split("\n");
            int largest = arr[0].length();
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].length() > largest) {
                    largest = arr[i].length();
                }
            }
            return largest;
        } else {
            int res = 0;
            int tmp1 = input.indexOf("\n\t");
            res += tmp1;
            res++;
            int tmp2 = input.indexOf("\n\t\t");
            res += tmp2 - (tmp1 + 2);
            res++;
            int tmp3 = input.indexOf("\n\t\t", tmp2 + 1);
            res += tmp3 - (tmp2 + 3);
            return res;
        }
    }
}
