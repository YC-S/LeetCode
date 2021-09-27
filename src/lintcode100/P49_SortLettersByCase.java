package lintcode100;

public class P49_SortLettersByCase {
  public static void sortLetters(char[] chars) {
    int left = 0, right = chars.length - 1;
    // 两指针相向移动，交会则结束
    while (left <= right) {
      // 左指针向右移动，直到找到第一个大写字母
      while (left <= right && Character.isLowerCase(chars[left])) {
        left++;
      }

      // 右指针向左移动，直到找到第一个小写字母
      while (left <= right && Character.isUpperCase(chars[right])) {
        right--;
      }

      // 将左边的大写字母和右边的小写字母交换位置
      if (left <= right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
        left++;
        right--;
      }
    }
  }

  public static void main(String[] args) {
    char[] chars = new char[] {'a', 'b', 'A', 'c', 'D'};
    sortLetters(chars);
    System.out.println(chars);
  }
}
