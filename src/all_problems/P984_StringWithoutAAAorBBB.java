package all_problems;

public class P984_StringWithoutAAAorBBB {
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder(a + b);
        char aa = 'a', bb = 'b';
        int i = a, j = b;
        if (b > a) {
            aa = 'b';
            bb = 'a';
            i = b;
            j = a;
        }
        while (i-- > 0) {
            res.append(aa);
            if (i > j) {
                res.append(aa);
                --i;
            }
            if (j-- > 0) res.append(bb);
        }
        return res.toString();
    }
}
