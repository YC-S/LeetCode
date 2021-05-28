package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P1868_ProductOfTwoRunLengthEncodedArrays {
  int k = -1;

  public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
    List<List<Integer>> resultant = new ArrayList<>();
    int i = 0, j = 0;
    int used1 = 0, used2 = 0;
    while (i < encoded1.length) {
      int m = Math.abs(encoded1[i][1] - used1);
      int n = Math.abs(encoded2[j][1] - used2);
      if (m < n) {
        addInResultantList(resultant, encoded1[i][0] * encoded2[j][0], m);
        i++;
        used2 += m;
        used1 = 0;
      } else if (n < m) {
        addInResultantList(resultant, encoded1[i][0] * encoded2[j][0], n);
        j++;
        used1 += n;
        used2 = 0;
      } else {
        addInResultantList(resultant, encoded1[i][0] * encoded2[j][0], n);
        j++;
        i++;
        used1 = 0;
        used2 = 0;
      }
    }
    return resultant;
  }

  public void addInResultantList(List<List<Integer>> resultant, int product, int freq) {
    if (k == -1 || resultant.get(k).get(0) != product) {
      List<Integer> l = new ArrayList<>();
      l.add(product);
      l.add(freq);
      resultant.add(l);
      k++;
    } else {
      resultant.get(k).set(1, resultant.get(k).get(1) + freq);
    }
  }
}
