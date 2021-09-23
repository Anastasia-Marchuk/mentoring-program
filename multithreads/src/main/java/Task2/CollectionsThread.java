package src.main.java.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class CollectionsThread {

    public void addElement(List list){
        Random random = new Random(1);
        for (int key = 1; key <20; key++) {
            int value = random.nextInt(10);
            list.add(value);
            String output = String.format("Thread_1 add => %s", value);
            System.out.println(output);
        }
    }

    public void summElement(List <Integer> list) {
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
            String output = String.format("Thread_2 sum is [%d]", sum);
            System.out.println(output);

        }
    }

    public void sqrElement(ArrayList<Integer> list){
//        try {
//            sleep(400);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
            double sum_sqrt = 0;
            for (int i = 0; i < list.size(); i++) {
                sum_sqrt = sum_sqrt + Math.sqrt(list.get(i));
                String output = "Thread_3  square root of sum of squares is " + sum_sqrt;
                System.out.println(output);
            }
            String output = "Thread_3  square root of sum of squares is " + sum_sqrt;
            System.out.println(output);
    }


    public static void main(String[] args) {
        CollectionsThread collectionsThread = new CollectionsThread();
        ArrayList<Integer> list = new ArrayList<>();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                collectionsThread.addElement(list);
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(101);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                collectionsThread.summElement(list);
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(this) {
                    collectionsThread.sqrElement(list);
                }

            }
        };
        Thread thread4 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(this) {
                    collectionsThread.sqrElement(list);
                }

            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
