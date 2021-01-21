package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель клиента банка
 * @author ALEXEY MERKULOV
 * @version 1.0
 */
public class User {
    /**
     * Хранение номера паспорта клиента осуществляется в поле c типом String
     */
    private String passport;
    /**
     * Хранение имени клиента осуществляется в поле c типом String
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить значение номера паспорта клиента
     * @return возвращает значение номера паспорта из соответствующего поля
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет задать значение полю с номером паспорта клиента
     * @param passport значение номера паспорта, которое записывается в соответствующее поле
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя клиента
     * @return возвращает имя клиента из соответствующего поля
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет задать значение полю с именем клиента
     * @param username имя клиента, которое записывается в соответствующее поле
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}