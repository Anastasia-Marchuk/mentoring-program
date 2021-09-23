package Task5.daoimpl;

import Task5.model.Account;
import Task5.model.Currency;
import Task5.dao.AccountDao;
import Task5.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static Task5.model.Currency.*;

public class AccountDaoImpl implements AccountDao {
    List<Account> accounts;
    User user;

    public AccountDaoImpl(User user){
        accounts = new ArrayList<Account>();
        Account account1 = new Account(0, user, USD, new BigDecimal(0.00));
        Account account2 = new Account(1, user, EUR, new BigDecimal(0.00));
        Account account3 = new Account(2, user, BYR, new BigDecimal(0.00));
        accounts.add(account1);
        updateFile(account1,user);
        accounts.add(account2);
        updateFile(account2,user);
        accounts.add(account3);
        updateFile(account3,user);

    }

    @Override
    public void updateFile(Account account, User user){

        try(FileWriter writer = new FileWriter("/home/anastasia/EpamMentoringProgram/threads/src/main/resources/"+user.getLastName()+"-account-"+account.getCurrency()+".txt", false))
        {
            String text = "Account: " + account.getAccountNumber() + ", "+account.getCurrency()+", updated amount in the database. Amount is "+accounts.get(account.getAccountNumber()).getMoney();
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void deleteAccount(Account account) {
        accounts.remove(account.getAccountNumber());
        System.out.println("Account: Roll No " + account.getAccountNumber() + ", deleted from database");
    }

    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account getAccount(int rollNo) {
        return null;
    }

    @Override
    public Account getAccountNumber(int num) {
        return accounts.get(num);
    }

    @Override
    public void updateCurrencyAccount(Account account, Currency curr) {
        switch(accounts.get(account.getAccountNumber()).getCurrency()){
            case USD:
                switch (curr){
                    case USD:
                        break;
                    case EUR:
                        accounts.get(account.getAccountNumber()).setMoney(account.getMoney().multiply(new BigDecimal(1.32)));
                        accounts.get(account.getAccountNumber()).setCurrency(curr);
                        updateFile(account,account.getUser());
                        break;
                    case BYR:
                        accounts.get(account.getAccountNumber()).setMoney(account.getMoney().multiply(new BigDecimal(2.60)));
                        accounts.get(account.getAccountNumber()).setCurrency(curr);
                        updateFile(account,account.getUser());
                        break;
                    default:
                        System.out.println("Sorry. This currency doesn't exsist");
                        break;
                }
                break;
            case BYR:
                switch (curr){
                    case USD:
                        accounts.get(account.getAccountNumber()).setMoney(account.getMoney().multiply(new BigDecimal(0.4)));
                        accounts.get(account.getAccountNumber()).setCurrency(curr);
                        updateFile(account,account.getUser());
                        break;
                    case EUR:
                        accounts.get(account.getAccountNumber()).setMoney(account.getMoney().multiply(new BigDecimal(0.33)));
                        accounts.get(account.getAccountNumber()).setCurrency(curr);
                        updateFile(account,account.getUser());
                        break;
                    case BYR:
                        break;
                    default:
                        System.out.println("Sorry. This currency doesn't exsist");
                        break;
                }
                break;
            case EUR:
                switch (curr){
                    case USD:
                        accounts.get(account.getAccountNumber()).setMoney(account.getMoney().multiply(new BigDecimal(0.87)));
                        accounts.get(account.getAccountNumber()).setCurrency(curr);
                        updateFile(account,account.getUser());

                        break;
                    case EUR:
                        break;
                    case BYR:
                        accounts.get(account.getAccountNumber()).setMoney(account.getMoney().multiply(new BigDecimal(3.24)));
                        accounts.get(account.getAccountNumber()).setCurrency(curr);
                        updateFile(account,account.getUser());
                        break;
                    default:
                        System.out.println("Sorry. This currency doesn't exsist");
                        break;
                }
                break;
        }

        System.out.println("Account: " + account.getAccountNumber() +
                ", updated currency in the database to "+account.getCurrency()+". Amount is "+accounts.get(account.getAccountNumber()).getMoney()+" " + curr.toString());
    }

    public void updateAmoutOfMoney(Account account) {
        accounts.get(account.getAccountNumber()).setMoney(account.getMoney());
        System.out.println("Account: " + account.getAccountNumber() + ", "+account.getCurrency()+", updated amount in the database. Amount is "+accounts.get(account.getAccountNumber()).getMoney());
    }
}
