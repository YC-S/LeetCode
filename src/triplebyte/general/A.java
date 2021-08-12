package triplebyte.general;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class A {
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
    Arrays.asList(3, 2, 1)
        .forEach(
            (d) -> {
              new Thread(
                      () -> {
                        try {
                          Thread.sleep(d * 1000);
                        } catch (InterruptedException e) {
                          e.printStackTrace();
                        }
                        q.add(d);
                      })
                  .start();
            });
    System.out.println(q.take());
  }
}
