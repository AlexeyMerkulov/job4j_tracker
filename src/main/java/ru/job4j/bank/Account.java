package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author ALEXEY MERKULOV
 * @version 1.0
 */
public class Account {
    /**
     * Хранение реквизитов клиента осуществляется в поле c типом String
     */
    private String requisite;
    /**
     * Хранение сведений о балансе клиента осуществляется в поле с типом double
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить значение реквизитов счета
     * @return возвращает значение реквизитов из соответствующего поля
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет задать значение полю с реквизитами счета
     * @param requisite значение реквизитов, которое записывается в соответствующее поле
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить значение баланса счета
     * @return возвращает значение баланса из соответствующего поля
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет задать значение полю с балансом счета
     * @param balance значение баланса, которое записывается в соответствующее поле
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}