/**
 * Задание: метод принимает отображение ключ(id пользователя) -
 * значение (имя пользователя), список id пользователей, список пользователей.
 * Необходимо обновить информацию в отображении следующим образом:
 *
 * 1. Удалить все пары ключ-значение которые соответствуют каждому id из списка id
 *
 * 2. Удалить все пары ключ значения, которые соответствуют списку пользователей
 * (тут будет необходимо использовать геттеры, чтобы получить доступ к значениям
 * в полях объектов типа User).
 */
package ru.job4j.exercises;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RemoveElements {
    public static Map<Integer, String> removeElement(Map<Integer, String> data,
                                                     List<Integer> ids,
                                                     List<User> users) {
        for (Integer id : ids) {
            data.remove(id);
        }
        for (User user : users) {
            data.remove(user.getId(), user.getName());
        }
        return data;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
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
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}