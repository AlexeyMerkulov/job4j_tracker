package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает операции бансковского сервиса
 * @author ALEXEY MERKULOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о клиенте банка и списке его счетов происходит в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового клиента с пустым списком счетов в коллекцию
     * В случае, если такой клиент уже существует в коллекции, то операция не выполняется
     * @param user клиент, который добавляется в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет клиенту банка
     * Если клиент банка не был найден по номеру паспорта или такой счет уже существует,
     * то операция не выполняется
     * @param passport номер паспорта клиента
     * @param account банковский счет, который требуется добавить
     */
    public void addAccount(String passport, Account account) {
        User key = findByPassport(passport);
        if (key != null) {
            List<Account> accounts = users.get(key);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск клиента банка по номеру паспорта
     * @param passport номер паспорта клиента
     * @return возвращает искомого клиента или null, если такой клиент не был найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск счета по номеру паспорта клиента и реквизитам счета
     * @param passport номер паспорта клиента
     * @param requisite реквизиты искомого банковского счета
     * @return возвращает банковский счет или null, если клиент не найден или
     * отсутствуют требуемые рекивизиты
     */
    public Account findByRequisite(String passport, String requisite) {
        User key = findByPassport(passport);
        if (key != null) {
            return users.get(key)
                    .stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег со счета одного клиента на счет другого
     * @param srcPassport паспорт клиента, который осуществляет перевод денег
     * @param srcRequisite реквизиты счета, с которого осуществляют перевод денег
     * @param destPassport паспорт клиента, которому переводят деньги
     * @param destRequisite реквизиты счета клиента, которому переводят деньги
     * @param amount сумма денежного перевода
     * @return возвращает true, если операция проведена успешно и false,
     * если хотя бы один из клиентов или один из счетов не будет найден, или
     * суммы на счете будет недостаточно для перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() - amount >= 0) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}