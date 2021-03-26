package company.bht;

import java.util.*;

public class ReFormatDate {
    public static List<String> preprocessData(List<String> dates) {
        List<String> res = new ArrayList<>();
        for (String date : dates) {
            res.add(helper(date));
        }
        return res;
    }

    public static String helper(String date) {

        String[] mon = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put(mon[i], i + 1);
        }

        String[] arr = date.split(" ");
        StringBuilder sb = new StringBuilder();
        // Year
        sb.append(arr[2]);
        sb.append("-");
        // Month
        int month = map.get(arr[1]);
        if (month < 10) sb.append(0);
        sb.append(month);
        sb.append("-");
        // Day
        String day = arr[0].substring(0, arr[0].length() - 2);
        if (day.length() < 2) {
            sb.append("0");
        }
        sb.append(day);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(preprocessData(Arrays.asList("1st Mar 1974", "22nd Jan 2013", "7th Apr 1904")));
    }


}
