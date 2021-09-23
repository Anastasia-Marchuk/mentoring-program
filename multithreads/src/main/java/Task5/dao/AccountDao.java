package Task5.dao;

import Task5.model.Account;
import Task5.model.Currency;
import Task5.model.User;

import java.util.List;

public interface AccountDao {
    public List<Account> getAllAccounts();
    public Account getAccount(int rollNo);
    public Account getAccountNumber(int num);
    public User getUser();
    public void updateFile(Account account, User user);
    public void updateCurrencyAccount(Account account, Currency currency);
    public void deleteAccount(Account account);
    public void updateAmoutOfMoney(Account account);
}