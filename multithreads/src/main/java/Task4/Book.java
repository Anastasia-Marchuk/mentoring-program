package Task4;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {

    private static final AtomicInteger counter = new AtomicInteger(0);

    private final int id;

    public Book() {
        id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Book id=%d", id);
    }
}