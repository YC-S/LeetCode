package all_problems;

import java.util.PriorityQueue;

public class P1183_MaximumNumberOfOnes {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int x = 0; x < sideLength; x++)
            for (int y = 0; y < sideLength; y++)
                pq.offer(new Point(x, y, width, height, sideLength));
        int res = 0;
        for (int i = 0; i < maxOnes; i++) {
            Point p = pq.poll();
            res += p.count;
        }
        return res;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int count;

        public Point(int x, int y, int width, int height, int sideLength) {
            this.x = x;
            this.y = y;
            count = (width / sideLength) * (height / sideLength) + //number of whole squares with side sideLength in our matrix
                    (x < width % sideLength ? 1 : 0) * (height / sideLength) + //if we can fit 1 into part squares to the right
                    (y < height % sideLength ? 1 : 0) * (width / sideLength) + //if we can fit 1 into part squares at the bottom
                    (x < width % sideLength && y < height % sideLength ? 1 : 0);//if we can fit 1 into bottom right square
        }

        @Override
        public int compareTo(Point other) {
            return other.count - this.count; //for max priority queue so points sorted in descending order
        }
    }

}
