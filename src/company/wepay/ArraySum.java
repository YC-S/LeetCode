package company.wepay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraySum {
    public static boolean arraySum(List<Integer> inputs, List<Integer> tests) {
        Set<Integer> set = new HashSet<>();
        for (Integer test : tests) {
            set.add(test);
        }
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < i; j++) {
                int cur = inputs.get(i) + inputs.get(j);
                if (set.contains(cur)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(-1, 8, 3);
        List<Integer> l2 = Arrays.asList(3, 7, 2);
        List<Integer> l3 = Arrays.asList(9, 6, 12);
        List<Integer> l4 = Arrays.asList(1, 2, 3);
        System.out.println(arraySum(l1, l2));
        System.out.println(arraySum(l3, l4));
    }
}
