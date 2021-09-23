package Task3;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageBus {
    public static void main(String[] args)
            throws InterruptedException
    {
        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }


    public static class PC {

        // Create a list shared by producer and consumer
        // Size of list is 2.
        LinkedList<String> list = new LinkedList<>();
        int capacity = 3;
        ;

        public void produce() throws InterruptedException
        {
          //  int value = 0;
            int a=0;
         //   String value = "Message_"+String.valueOf(a);
            while (true) {
                synchronized (this)
                {
                    String value = "Message_"+String.valueOf(a);
                    // producer thread waits while list
                    // is full
                    while (list.size() == capacity)
                        wait();

                    System.out.println("Producer produced-"
                            + value);

                    // to insert the jobs in the list
                    list.add(value);
                    a++;

                    // notifies the consumer thread that
                    // now it can start consuming
                    notify();

                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    // consumer thread waits while list
                    // is empty
                    while (list.size() == 0)
                        wait();

                    // to retrive the ifrst job in the list
                  //  int val = list.removeFirst();
                    String val = list.removeFirst();

                    System.out.println("Consumer consumed-"
                            + val);
                    Logger.getLogger(PC.class.getName()).log(Level.INFO, "LOGG CONSUMER CONSUMED "+val);

                    notify();

                    Thread.sleep(1000);
                }
            }
        }
    }
}