package all_problems;

public class P1592_RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        // var words = text.trim().split("\\s+");
        int len = text.length();
        //System.out.println(len);
        text = text.trim();
        //System.out.println(text);
        String[] str = text.split(" ");
        //System.out.println(str.length);
        int countWords = 0;
        int lenWords = 0;
        for (String s : str)
            if (s.length() != 0) {
                countWords++;
                s = s.trim();
                lenWords += s.length();
            }
        int cnt = len - lenWords;
        if (countWords == 1) {
            String res = str[0];
            for (int i = 0; i < cnt; i++)
                res = res + " ";
            return res;
        }
        int countSpace = (cnt) / (countWords - 1);
        int endSpace = (cnt) % (countWords - 1);

        StringBuilder spacesWords = new StringBuilder();
        while (countSpace-- > 0)
            spacesWords.append(" ");
        StringBuilder spacesEnd = new StringBuilder();
        while (endSpace-- > 0)
            spacesEnd.append(" ");
        StringBuilder res = new StringBuilder();
        for (String s : str) {
            if (s.length() != 0) {
                countWords--;
                res.append(s);
                if (countWords == 0)
                    res.append(spacesEnd);
                else
                    res.append(spacesWords);
            }
        }


        //    System.out.println(countWords+" "+lenWords+" string new : "+res.toString());
        return res.toString();
    }
}
