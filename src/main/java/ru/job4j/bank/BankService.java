package ru.job4j.bank;

import java.util.*;

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
        Optional<User> key = findByPassport(passport);
        if (key.isPresent()) {
            List<Account> accounts = users.get(key.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск счета по номеру паспорта клиента и реквизитам счета
     * @param passport номер паспорта клиента
     * @param requisite реквизиты искомого банковского счета
     * @return возвращает банковский счет или null, если клиент не найден или
     * отсутствуют требуемые рекивизиты
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() - amount >= 0) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}