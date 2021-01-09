package all_problems;

public class P1640_CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append("#");
            sb.append(x);
            sb.append("#");
        }
        for (int i = 0; i < pieces.length; i++) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < pieces[i].length; j++) {
                res.append("#");
                res.append(pieces[i][j]);
                res.append("#");
            }
            if (!sb.toString().contains(res.toString())) {
                return false;
            }
        }
        return true;
    }
}
