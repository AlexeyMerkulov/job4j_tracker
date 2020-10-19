package ru.job4j.tracker;

public class Programmer extends Engineer {
    private String programLanguage;

    public String getProgramLanguage() {
        return programLanguage;
    }

    public App codeApp(Task task, Computer computer) {
        return new App();
    }
}
