package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output output = new ConsoleOutput();
        Input input = new StubInput(Arrays.asList("0", "Item name", "1"));
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new CreateAction(output), new ExitAction());
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new StubInput(Arrays.asList("0", String.valueOf(item.getId()),
                replacedName, "1"));
        List<UserAction> actions = Arrays.asList(new EditAction(output), new ExitAction());
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new StubInput(Arrays.asList("0", String.valueOf(item.getId()), "1"));
        List<UserAction> actions = Arrays.asList(new DeleteAction(output), new ExitAction());
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(Arrays.asList("0"));
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Exit program ===" + System.lineSeparator()));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(Arrays.asList("0", "1"));
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("New Item"));
        List<UserAction> actions = Arrays.asList(new ShowAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. === Exit program ===" + System.lineSeparator()
                        + "=== Show all items ===" + System.lineSeparator()
                        + item.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator() + "0. === Show all items ==="
                        + System.lineSeparator() + "1. === Exit program ==="
                        + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(Arrays.asList("0", item.getName(), "1"));
        List<UserAction> actions = Arrays.asList(new FindNameAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Finding Item by name ==="
                        + System.lineSeparator() + "1. === Exit program ==="
                        + System.lineSeparator() + "=== Finding Item by name ==="
                        + System.lineSeparator() + item.toString()
                        + System.lineSeparator() + "Menu." + System.lineSeparator()
                        + "0. === Finding Item by name ===" + System.lineSeparator()
                        + "1. === Exit program ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(Arrays.asList("0", String.valueOf(item.getId()), "1"));
        List<UserAction> actions = Arrays.asList(new FindIDAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Finding by Id ===" + System.lineSeparator()
                        + "1. === Exit program ===" + System.lineSeparator()
                        + "=== Finding by Id ===" + System.lineSeparator()
                        + item.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator() + "0. === Finding by Id ==="
                        + System.lineSeparator() + "1. === Exit program ==="
                        + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(Arrays.asList("2", "0"));
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit program ===%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit program ===%n"
                )
        ));
    }
}