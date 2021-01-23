package all_problems;

public class P1154_DayOfTheYear {
    public int dayOfYear(String date) {
        String[] s = date.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        boolean isLeap = checkYear(year);
        int noOfDays = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            if (isLeap && i == 1) {
                noOfDays += days[i] + 1;
                continue;
            }
            noOfDays += days[i];
        }
        return noOfDays + day;
    }

    private boolean checkYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }
}
