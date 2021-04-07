package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> res = new ArrayList<>();
        helper(res, array, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> array, int index) {
        if (index == array.size()) {
            res.add(new ArrayList<>(array));
            return;
        }
        for (int i = index; i < array.size(); i++) {
            swap(array, index, i);
            helper(res, array, index + 1);
            swap(array, index, i);
        }
    }

    private static void swap(List<Integer> array, int a, int b) {
        int tmp = array.get(a);
        array.set(a, array.get(b));
        array.set(b, tmp);
    }

    public static void main(String[] args) {
        System.out.println(getPermutations(Arrays.asList(1, 2, 3)));
    }
}
