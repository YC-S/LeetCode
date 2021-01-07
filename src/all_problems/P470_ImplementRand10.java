package all_problems;

import java.util.Random;

public class P470_ImplementRand10 {
    private int rand7() {
        Random random = new Random();
        return random.nextInt(7);
    }

    public int rand10() {
        int rand40 = 40;
        while (rand40 >= 40) {
            rand40 = (rand7() - 1) * 7 + rand7() - 1;
        }
        return rand40 % 10 + 1;
    }
}
