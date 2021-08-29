package contest.leetcode.单周赛._256;

import java.util.Arrays;
import java.util.PriorityQueue;

public class C {
  public static int minSessions(int[] tasks, int sessionTime) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int task : tasks) {
      pq.offer(task);
    }
    int curSession = sessionTime;
    int res = 1;
    while (!pq.isEmpty()) {
      int tmp = pq.poll();
      if (curSession < tmp) {
        curSession = sessionTime;
        pq.offer(tmp);
        res++;
      } else {
        curSession -= tmp;
      }
    }
    return res;
  }

  public static int minSessions2(int[] tasks, int sessionTime) {
    Arrays.sort(tasks);
    int i = 0, j = tasks.length - 1;
    int res = 0;
    int curSession = sessionTime;
    while (i <= j) {
      while (i <= j && curSession >= tasks[j]) {
        curSession -= tasks[j];
        j--;
      }
      while (i <= j && curSession >= tasks[i]) {
        curSession -= tasks[i];
        i++;
      }
      res++;
      curSession = sessionTime;
    }
    return res;
  }

  public static int minSessions3(int[] tasks, int sessionTime) {
    Arrays.sort(tasks);
    int i = 0, j = tasks.length - 1;
    int res = 0;
    int curSession = sessionTime;
    while (i <= j) {
      while (i <= j && curSession >= tasks[j]) {
        curSession -= tasks[j];
        j--;
      }
      int tmpIdx = i;
      boolean flag = false;
      while (i <= j && curSession >= tasks[i]) {
        i++;
        flag = true;
      }
      if (i != 0 && flag) {
        int minIndex = i - 1;
        if (curSession >= tasks[minIndex]) {
          curSession -= tasks[minIndex];
          swap(tasks, minIndex, tmpIdx);
          i = tmpIdx + 1;
        }
      }
      res++;
      curSession = sessionTime;
    }
    return res;
  }

  private static void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

  public static void main(String[] args) {
    //        System.out.println(minSessions3(new int[]{1,2,3}, 3));
    //        System.out.println(minSessions3(new int[]{3,1,3,1,1}, 8));
    //        System.out.println(minSessions3(new int[]{1,2,3,4,5}, 15));
    //        System.out.println(minSessions3(new int[]{7,4,3,8,10}, 12));
    //        System.out.println(minSessions3(new int[]{1,5,7,10,3,8,4,2,6,2}, 10));
    //        System.out.println(minSessions3(new int[]{10,3,8,8,1,10}, 13));
    System.out.println(minSessions3(new int[] {3, 3, 3, 3, 4, 5, 5, 5, 7, 9}, 12));
  }
}
