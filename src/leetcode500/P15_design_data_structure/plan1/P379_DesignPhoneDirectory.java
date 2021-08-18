package leetcode500.P15_design_data_structure.plan1;

public class P379_DesignPhoneDirectory {

  int[] phoneArray; // save all the phone number array
  int position; // position in the phone number array

  public P379_DesignPhoneDirectory(int maxNumbers) {
    phoneArray = new int[maxNumbers];
    for (int i = 0; i < maxNumbers; ++i) {
      phoneArray[i] = (i + 1) % maxNumbers;
    }
    position = 0;
  }

  public int get() {
    if (phoneArray[position] == -1) return -1;
    int ret = position;
    position = phoneArray[position];
    phoneArray[ret] = -1;
    return ret;
  }

  public boolean check(int number) {
    return phoneArray[number] != -1;
  }

  public void release(int number) {
    if (phoneArray[number] != -1) return;
    phoneArray[number] = position;
    position = number;
  }
}
