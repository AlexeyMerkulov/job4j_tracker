package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item(100, "Request");
        LocalDateTime currentDateTime = item.getLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println("Отформатированная текущая дата и время: " + currentDateTimeFormat);
        System.out.println(item.toString());
    }
}
