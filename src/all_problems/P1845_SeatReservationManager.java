package all_problems;

import java.util.PriorityQueue;

public class P1845_SeatReservationManager {
  PriorityQueue<Integer> pq;
  int count;

  public P1845_SeatReservationManager(int n) {
    count = 1;
    pq = new PriorityQueue<>();
  }

  public int reserve() {
    if (pq.size() == 0) return count++;

    return pq.poll();
  }

  public void unreserve(int seatNumber) {
    pq.add(seatNumber);
  }
}
