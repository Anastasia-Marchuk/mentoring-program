package Task5.service;
import Task5.dao.AccountDao;
import Task5.daoimpl.AccountDaoImpl;
import Task5.model.Account;
import Task5.model.Currency;
import Task5.model.User;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecutorsExample {
    public static void main(String[] args) throws Exception {

        Logger logger=Logger.getLogger(String.valueOf(DaoServiceDemo.class));

        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service with a thread pool of Size 2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        User user=new User("Anastasia", "Marchuk");
        User user2=new User("Ivan", "Sokolov");
        //User user2=new User("Ivan4", "Sokolov");
        AccountDao accountDao = new AccountDaoImpl(user);
        AccountDao accountDao2 = new AccountDaoImpl(user2);
        DaoServiceDemo daoServiceDemo=new DaoServiceDemo();

        Runnable task1 = () -> {
            System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());

            try {

                Account account0 =accountDao.getAllAccounts().get(0);
                daoServiceDemo.addSum(accountDao, BigDecimal.valueOf(20.00),0);

                Account account1 =accountDao.getAllAccounts().get(1);
                daoServiceDemo.addSum(accountDao, BigDecimal.valueOf(110.00), 1);

                Account account2 =accountDao.getAllAccounts().get(2);
                daoServiceDemo.addSum(accountDao, BigDecimal.valueOf(40.00),2);

                DaoServiceDemo.changeCurrency(accountDao,account0, Currency.EUR);
                DaoServiceDemo.changeCurrency(accountDao,account1,Currency.BYR);
                DaoServiceDemo.changeCurrency(accountDao,account2,Currency.USD);


                System.out.println("\nCurrent updating for user " +accountDao.getAllAccounts().get(0).getUser().getLastName());
                daoServiceDemo.printAccounts(accountDao);
                logger.log(Level.INFO,"List of current accounts "+accountDao.getAllAccounts().get(0).getUser().getLastName());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable task2 = () -> {
            System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
            try {
                Account account0 =accountDao2.getAllAccounts().get(0);
                daoServiceDemo.addSum(accountDao2, BigDecimal.valueOf(200.00),0);

                Account account1 =accountDao2.getAllAccounts().get(1);
                daoServiceDemo.addSum(accountDao2, BigDecimal.valueOf(1000.00), 1);

                Account account2 =accountDao2.getAllAccounts().get(2);
                daoServiceDemo.addSum(accountDao2, BigDecimal.valueOf(40.00),2);

                DaoServiceDemo.changeCurrency(accountDao2,account0, Currency.EUR);
                DaoServiceDemo.changeCurrency(accountDao2,account1,Currency.USD);
                DaoServiceDemo.changeCurrency(accountDao2,account2,Currency.BYR);

                System.out.println("\nCurrent updating for user " +accountDao2.getAllAccounts().get(0).getUser().getLastName());
                daoServiceDemo.printAccounts(accountDao2);
                logger.log(Level.INFO,"List of current accounts "+accountDao2.getAllAccounts().get(0).getUser().getLastName());
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };


        System.out.println("Submitting the tasks for execution...");
        executorService.submit(task1);
        executorService.submit(task2);

        executorService.shutdown();
    }
}