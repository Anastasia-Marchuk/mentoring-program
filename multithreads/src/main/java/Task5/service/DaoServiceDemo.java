package Task5.service;

import Task5.dao.AccountDao;
import Task5.daoimpl.AccountDaoImpl;
import Task5.model.Account;
import Task5.model.Currency;
import Task5.model.User;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoServiceDemo {

    Logger logger=Logger.getLogger(String.valueOf(DaoServiceDemo.class));
    public static void main(String[] args) throws Exception {

        Logger logger=Logger.getLogger(String.valueOf(DaoServiceDemo.class));
        DaoServiceDemo daoServiceDemo=new DaoServiceDemo();

        User user=new User("Anastasia", "Marchuk");
        User user2=new User("Ivan", "Sokolov");
        //example of exception:
        //User user2=new User("Ivan4", "Sokolov");



        AccountDao accountDao = new AccountDaoImpl(user);
        AccountDao accountDao2 = new AccountDaoImpl(user2);


        daoServiceDemo.printAccounts(accountDao);


        Account account0 =accountDao.getAllAccounts().get(0);
        daoServiceDemo.addSum(accountDao, BigDecimal.valueOf(20.00),0);

        Account account1 =accountDao.getAllAccounts().get(1);
        daoServiceDemo.addSum(accountDao, BigDecimal.valueOf(110.00), 1);

        Account account2 =accountDao.getAllAccounts().get(2);
        daoServiceDemo.addSum(accountDao, BigDecimal.valueOf(40.00),2);

        changeCurrency(accountDao,account0, Currency.EUR);
        changeCurrency(accountDao,account1,Currency.BYR);
        changeCurrency(accountDao,account2,Currency.USD);


        System.out.println("\nCurrent updating for user " +accountDao.getAllAccounts().get(0).getUser().getLastName());
        daoServiceDemo.printAccounts(accountDao);
        logger.log(Level.INFO,"List of current accounts "+accountDao.getAllAccounts().get(0).getUser().getLastName());


        System.out.println("\nCurrent updating for user " +accountDao2.getAllAccounts().get(0).getUser().getLastName());
        daoServiceDemo.printAccounts(accountDao2);
        logger.log(Level.INFO,"List of current accounts "+accountDao2.getAllAccounts().get(0).getUser().getLastName());


    }

    public  void printAccounts(AccountDao accountDao){
        for (Account accountFinal : accountDao.getAllAccounts()) {
            System.out.println("Account: " + accountFinal.getAccountNumber() + ", Amount : " + accountFinal.getMoney()+", Currency : " + accountFinal.getCurrency());
        }
    }

    public  void addSum(AccountDao accountDao, BigDecimal decimal, int i){

        Account account =accountDao.getAllAccounts().get(i);
        account.setMoney(account.getMoney().add(decimal));
        logger.log(Level.INFO,"add "+decimal+" "+accountDao.getAllAccounts().get(i).getCurrency()+" to account");
        accountDao.updateAmoutOfMoney(account);
        accountDao.updateFile(account,account.getUser());

    }

    public static void changeCurrency(AccountDao accountDao, Account account, Currency curr){
        Logger logger=Logger.getLogger(String.valueOf(DaoServiceDemo.class));
        logger.log(Level.INFO,"change currency from "+account.getCurrency()+" to "+curr.toString());

        accountDao.updateCurrencyAccount(account, curr);
    }

}