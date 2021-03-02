package company.wepay;

public class CurrencyRecognition {
    private static int whatCurrency(String s, int position) {
        final char DOLLAR = '$';
        final char EURO = '€';
        final char YEN = '¥';
        if (s.charAt(position) == DOLLAR) {
            return 1;
        } else if (s.charAt(position) == EURO) {
            return 2;
        } else if (s.charAt(position) == YEN) {
            return 3;
        } else {
            return -1;
        }
    }

    private static boolean helper(String s) {
        int currency = whatCurrency(s, 0);
        if (currency == -1) return false;
        int l, r = s.length() - 1;
        l = 1;
        boolean comma = false;
        int prev = s.length();

        for (int i = r; i >= l; i--) {
            if (comma && (prev - i - 1 == 3 && s.charAt(i) != ',')) {
                return false;
            }
            if (Character.isDigit(s.charAt(i))) {
                continue;
            } else if (s.charAt(i) == '.') {
                if (currency == 3 || (r - i) != 2) {
                    return false;
                }
                prev = i;
            } else if (s.charAt(i) == ',') {
                if (prev - i - 1 != 3) return false;
                comma = true;
                prev = i;
            } else {
                return false;
            }
        }
        if (s.charAt(l) == '0') {
            if (l == r) return true;
            return s.charAt(l + 1) == '.';

        }
        return true;
    }

    public static boolean isCurrency(String strAmount) {
        final int n = strAmount.length();
        if (n == 0 || strAmount.charAt(0) == ' ' || strAmount.charAt(n - 1) == ' ') {
            return false;
        }
        boolean negativeSeen = false;
        boolean leftSeen = false;
        int l = 0, r = n - 1;
        if (strAmount.charAt(l) == '-') {
            l++;
            negativeSeen = true;
        }
        if (strAmount.charAt(l) == '(' && strAmount.charAt(n - 1) == ')') {
            l++;
            r--;
            leftSeen = true;
        }
        if (strAmount.charAt(l) == '-') {
            if (leftSeen) {
                return false;
            }
            if (negativeSeen == false) {
                l++;
            } else {
                return false;
            }
        }
        return helper(strAmount.substring(l, r + 1));
    }

    public static void main(String[] args) {
        String s1 = "$450";
        String s2 = "-€23";
        String s3 = "(¥2400)";
        String s33 = "-(¥2400)";
        String s333 = "-¥2400";
        String s3333 = "-$2400";
        String s33333 = "-€2400";
        String s333333 = "-€2,400";
        String s4 = "$4,500.00";
        String s5 = "€0.25";

        //================================
        String s6 = "cat";
        String s7 = "£450";
        String s8 = "$45,0";
        String s9 = "$(€350";
        String s10 = "(-$3.50)";
        String s11 = "¥120.00";
        String s12 = "$-50";
        String s13 = " €43.25";
        String s14 = "$65.";
        String s15 = "€82.1";
        String s16 = "48.50";
        String s17 = "¥1200,000";


        System.out.println(isCurrency(s1));
        System.out.println(isCurrency(s2));
        System.out.println(isCurrency(s3));
        System.out.println(isCurrency(s33));
        System.out.println(isCurrency(s333));
        System.out.println(isCurrency(s3333));
        System.out.println(isCurrency(s33333));
        System.out.println(isCurrency(s333333));
        System.out.println(isCurrency(s4));
        System.out.println(isCurrency(s5));
        System.out.println(isCurrency(s6));
        System.out.println(isCurrency(s7));
        System.out.println(isCurrency(s8));
        System.out.println(isCurrency(s9));
        System.out.println(isCurrency(s10));
        System.out.println(isCurrency(s11));
        System.out.println(isCurrency(s12));
        System.out.println(isCurrency(s13));
        System.out.println(isCurrency(s14));
        System.out.println(isCurrency(s15));
        System.out.println(isCurrency(s16));
        System.out.println(isCurrency(s17));
    }
}
