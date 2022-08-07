package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindNameActionTest {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Test
    public void whenExecuteSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String nameOfFirstItem = "First Item";
        tracker.add(new Item(nameOfFirstItem));
        String nameOfSecondItem = "Second Item";
        Item secondItem = tracker.add(new Item(nameOfSecondItem));
        FindNameAction findNameAction = new FindNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(nameOfSecondItem);
        findNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Finding Item by name ===" + ln
                + String.format("id: %s, name: %s, created: %s", secondItem.getId(),
                secondItem.getName(), FORMATTER.format(secondItem.getCreated())) + ln));
    }

    @Test
    public void whenExecuteFailed() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String nameOfFirstItem = "First Item";
        tracker.add(new Item(nameOfFirstItem));
        String nameOfSecondItem = "Second Item";
        tracker.add(new Item(nameOfSecondItem));
        FindNameAction findNameAction = new FindNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("default");
        findNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Finding Item by name ===" + ln
                + "Items with requested name are not found" + ln));
    }
}