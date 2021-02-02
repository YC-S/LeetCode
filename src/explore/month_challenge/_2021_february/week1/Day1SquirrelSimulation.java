package explore.month_challenge._2021_february.week1;

public class Day1SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int dist = 0, d = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            int temp = distance(tree[0], tree[1], nut[0], nut[1]);
            dist += (2 * temp);
            d = Math.max(d, temp - distance(squirrel[0], squirrel[1], nut[0], nut[1]));
        }


        return dist - d;
    }

    public int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
