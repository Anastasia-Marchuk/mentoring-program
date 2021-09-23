package Task1;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SumThread extends Thread {
    private ConcurrentMap<Integer, Integer> map;
    private String name;
    final Lock lock = new ReentrantLock(true);


    public SumThread(ConcurrentMap<Integer, Integer> map,
                     String threadName) {
        this.map = map;
        this.name = threadName;
    }

    public void run() {
            int sum=0;

            for (int i = 1; i <=map.size(); i++) {
                lock.lock();
                sum=sum+map.get(i);
                String output = String.format("%s sum is [%d]",
                        name, sum);
                System.out.println(output);
                lock.unlock();
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
