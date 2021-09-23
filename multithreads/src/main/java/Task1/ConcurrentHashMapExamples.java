package Task1;

import java.util.concurrent.*;

public class ConcurrentHashMapExamples {

    public static void main(String[] args) {
     ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

     new AddThread(map, "ADD_Thread", 1).start();
     new SumThread(map, "SUM_Thread").start();


   }
}