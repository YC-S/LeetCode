package leetcode500.P15_design_data_structure.plan2;

class Reader4 {
  int read4(char[] buf4) {
    return 0;
  }
}

public class P157_ReadNCharactersGivenRead4 extends Reader4 {
  public int read(char[] buf, int n) {
    char[] tmp = new char[4];
    int idx = 0, pointer = 0;
    while (n > idx) {
      int len = read4(tmp);
      pointer = 0;
      while (idx < n && pointer < len) buf[idx++] = tmp[pointer++];
      if (len < 4) break;
    }
    return idx;
  }
}
