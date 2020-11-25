/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example46 {

    public static boolean leapyear(int y) {
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }

}
