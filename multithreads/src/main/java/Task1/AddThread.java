package Task1;

import java.util.Random;
import java.util.concurrent.ConcurrentMap;


public class AddThread extends Thread {
    private ConcurrentMap<Integer, Integer> map;
    private Random random;
    private String name;

    public AddThread(ConcurrentMap<Integer, Integer> map,
                     String threadName, long randomSeed) {
        this.map = map;
        this.random = new Random(randomSeed);
        this.name = threadName;
    }

    public void run() {

        for (int key = 1; key <=1000 ; key++) {
            int value = random.nextInt(10);
            if(map.putIfAbsent(key, value) == null) {

                    String output = String.format("%s has put [%d => %s]",
                            name, key, value);
                    System.out.println(output);
                try {
                    sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}