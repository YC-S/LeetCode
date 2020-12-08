/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.Java专项练习;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
class Line {

    public Point getPoint() {
        return new Point();
    }

    public class Point {

        public int x, y;
    }
}

public class Triangle {

    public Triangle() {
        Line.Point p = (new Line()).getPoint();
    }
}
