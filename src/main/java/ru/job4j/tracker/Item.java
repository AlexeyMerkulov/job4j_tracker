package ru.job4j.tracker;

import lombok.Data;

import static java.time.LocalDateTime.*;

import java.time.LocalDateTime;

@Data
public class Item {

    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.of(now().getYear(), now().getMonth(),
            now().getDayOfMonth(), now().getHour(), now().getMinute(), now().getSecond());

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }
}