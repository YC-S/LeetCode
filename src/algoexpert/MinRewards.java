package algoexpert;

import java.util.Arrays;

public class MinRewards {
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        for (int i = 1; i < scores.length; i++) {
            int j = i - 1;
            if (scores[i] > scores[j]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && scores[j] > scores[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }
        }
        int sum = 0;
        for (int reward : rewards) {
            sum += reward;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
//        System.out.println(minRewards(new int[]{0, 4, 2, 1, 3}));
//        System.out.println(minRewards(new int[]{2, 20, 13, 12, 11, 8, 4, 3, 1, 5, 6, 7, 9, 0}));
        System.out.println(minRewards(new int[]{800, 400, 20, 10, 30, 61, 70, 90, 17, 21, 22, 13, 12, 11, 8, 4, 2, 1, 3, 6, 7, 9, 0, 68, 55, 67, 57, 60, 51, 661, 50, 65, 53}));
    }
}
