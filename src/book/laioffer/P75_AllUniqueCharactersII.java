package book.laioffer;

public class P75_AllUniqueCharactersII {
  public boolean AllUnique(String word) {
    int[] bitMap = new int[8];
    for (int i = 0; i < word.length(); i++) {
      int c = word.charAt(i);
      int row = c / 32;
      int col = c % 32;
      if ((bitMap[row] >> col & 1) == 1) {
        return false;
      }
      bitMap[row] |= 1 << col;
    }
    return true;
  }
}
