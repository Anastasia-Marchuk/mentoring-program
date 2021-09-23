package Task4;

import java.util.HashSet;
import java.util.Set;

public abstract class BlockingObjectPool<T> {
    int size;
    private final Set<T> available = new HashSet<>();
    private final Set<T> blocked = new HashSet<>();

    protected abstract T create();

    /**
     * Creates filled pool of passed size
     * * * @param size of pool
     */
    public BlockingObjectPool(int size) {
        this.size = size;
    }

    /**
     * Gets object from pool or blocks if pool is empty
     * * * @return object from pool
     */
    public synchronized Object get() {
        if (available.isEmpty()) {
            available.add(create());
        }
        T instance = available.iterator().next();
        available.remove(instance);

        System.out.println("Blocked " + instance);
        blocked.add(instance);

        return instance;
    }

    /**
     * Puts object to pool or blocks if pool is full
     * * * @param object to be taken back to pool
     */
    public synchronized void put(T instance) {
            if(available.size() == size){
                blocked.add(instance);
                System.out.println("pool is full (size="+size+"), added "+instance+" to blocked "+ instance);
            } else {
                blocked.remove(instance);
                System.out.println("Put object to pool: " + instance);
                available.add(instance);
            }
        }


    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d blocked=%d", available.size(), blocked.size());
    }


    public static void main(String[] args) throws InterruptedException {

        BooksPoll pool = new BooksPoll(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    Book book1 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book2 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book3 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book33 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book1);
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book2);
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book4 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();


                    Book book5 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book34 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book1);
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book2);
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book3);
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book33);
                    System.out.println(pool.toString());
                    System.out.println();

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    Book book20 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book21 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book22 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book23 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book21);
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book20);
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book24 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();


                    Book book25 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    Book book26 = (Book) pool.get();
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book21);
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book22);
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book23);
                    System.out.println(pool.toString());
                    System.out.println();

                    pool.put(book24);
                    System.out.println(pool.toString());
                    System.out.println();

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

    class BooksPoll extends BlockingObjectPool<Book> {

        /**
         * Creates filled pool of passed size
         * * * @param size of pool
         *
         * @param size
         */
        public BooksPoll(int size) {
            super(size);
        }

        @Override
        protected Book create() {
            return new Book();
        }

}
