package company.others.heartdub;

public class MathChallenge {
    public static String MathChallenge(String str) {
        String[] arr = str.split(" ");
        String first = arr[0];
        String operator = arr[1];
        String second = arr[2];
        String result = arr[arr.length - 1];
        int res = 0;
        String x;

        if (result.contains("x")) {
            x = result;
            int first_operand = Integer.parseInt(first);
            int second_operand = Integer.parseInt(second);
            if (operator.equals("+")) {
                res = first_operand + second_operand;
            } else if (operator.equals("-")) {
                res = first_operand - second_operand;
            } else if (operator.equals("*")) {
                res = first_operand * second_operand;
            } else {
                res = first_operand / second_operand;
            }
        } else {
            int tmp = Integer.parseInt(result);
            if (first.contains("x")) {
                x = first;
                int second_operand = Integer.parseInt(second);
                if (operator.equals("+")) {
                    res = tmp - second_operand;
                } else if (operator.equals("-")) {
                    res = tmp + second_operand;
                } else if (operator.equals("*")) {
                    res = tmp / second_operand;
                } else {
                    res = tmp * second_operand;
                }
            } else {
                x = second;
                int first_operand = Integer.parseInt(first);
                if (operator.equals("+")) {
                    res = tmp - first_operand;
                } else if (operator.equals("-")) {
                    res = first_operand - tmp;
                } else if (operator.equals("*")) {
                    res = tmp / first_operand;
                } else {
                    res = first_operand / tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        String answer = String.valueOf(res);
        int k = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == 'x') {
                sb.append(answer.charAt(k));
                break;
            } else {
                k++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(MathChallenge("1x0 * 12 = 1200"));
    }
}
