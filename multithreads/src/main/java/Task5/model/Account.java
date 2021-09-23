package Task5.model;

import java.math.BigDecimal;

public class Account {

    private User user;
    private int accountNumber;
    private Currency currency;
    private BigDecimal  money;

    public Account(int accountNumber, User user, Currency currency, BigDecimal money){
        this.accountNumber = accountNumber;
        this.user=user;
        this.currency = currency;
        this.money=money;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setMoney(BigDecimal  money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal  getMoney() {
        return money;
    }

}
