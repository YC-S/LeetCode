package 牛客网.华为面试.第二轮;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q1 {
    public static int[][] rebuild(int[][] people) {
        // 改变量名
        // lambda表达式更好 java8特性
        Arrays.sort(people, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        // 对k升序排列 对w降序排列
        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p); // 在index p[1] 上添加新pair int[] p
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{8, 0}, {4, 4}, {8, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = rebuild(people);
        for (int[] list : ans) {
            System.out.println(Arrays.toString(list));
        }
        // [[4,1],[6,0],[5,0],[3,2],[2,2],[1,4]]
        // output [[5,0],[4,1],[2,2],[3,2],[1,4],[6,0]]
        // time complexity  n ^ 2
        // space complexity
    }


}
