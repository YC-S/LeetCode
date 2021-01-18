package all_problems;

public class P1003_CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String s) {
        String abc = "abc";

        while (s.contains(abc)) {
            s = s.replace(abc, "");
        }

        return s.isEmpty();
    }
}
