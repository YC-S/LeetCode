package contest.leetcode.单周赛._231;

public class P5697 {
    public static boolean checkOnesSegment(String s) {
        char[] array = s.toCharArray();
        boolean hasOneSegment = false;
        boolean prevIsOne = false;
        int count1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '1') {
                if (hasOneSegment == true && prevIsOne == false) {
                    return false;
                } else if (hasOneSegment == true && prevIsOne == true) {
                    count1++;
                    continue;
                } else if (hasOneSegment == false) {
                    if (prevIsOne == false || i == 0) {
                        hasOneSegment = true;
                    }
                    prevIsOne = true;
                    count1++;
                }
            } else {
                prevIsOne = false;
            }
        }
        return count1 >= 1 && hasOneSegment;
    }

    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001"));
        System.out.println(checkOnesSegment("110"));
        System.out.println(checkOnesSegment("11001"));
        System.out.println(checkOnesSegment("111111"));
        System.out.println(checkOnesSegment("00111111"));
        System.out.println(checkOnesSegment("001110111"));
        System.out.println(checkOnesSegment("110"));
    }
}
