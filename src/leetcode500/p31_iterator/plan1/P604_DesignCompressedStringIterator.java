package leetcode500.p31_iterator.plan1;

import java.util.LinkedList;
import java.util.Queue;

public class P604_DesignCompressedStringIterator {
  Queue<Pair> queue;

  public P604_DesignCompressedStringIterator(String compressedString) {
    queue = new LinkedList<>();
    char[] arr = compressedString.toCharArray();
    char tmp = ' ';
    int count = 0;
    for (int i = 0; i < compressedString.length(); i++) {
      if (Character.isLetter(arr[i]) && count != 0) {
        queue.add(new Pair(tmp, count));
        count = 0;
      }
      if (Character.isLetter(arr[i])) {
        tmp = arr[i];
      } else {
        count = count * 10 + (arr[i] - '0');
      }
    }
    if (tmp != ' ' && count != 0) {
      queue.add(new Pair(tmp, count));
      count = 0;
    }
  }

  public char next() {
    if (!hasNext()) {
      return ' ';
    } else {
      Pair tmp = queue.peek();
      tmp.setNum(tmp.getNum() - 1);
      char res = tmp.getC();
      if (tmp.getNum() == 0) {
        queue.poll();
      }
      return res;
    }
  }

  public boolean hasNext() {
    if (queue.isEmpty()) {
      return false;
    }
    return queue.peek().getNum() != 0;
  }

  class Pair {
    char c;
    int num;

    public Pair(char c, int num) {
      this.c = c;
      this.num = num;
    }

    public char getC() {
      return c;
    }

    public void setC(char c) {
      this.c = c;
    }

    public int getNum() {
      return num;
    }

    public void setNum(int num) {
      this.num = num;
    }
  }
}
