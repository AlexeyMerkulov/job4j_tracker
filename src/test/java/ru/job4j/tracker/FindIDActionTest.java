package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindIDActionTest {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Test
    public void whenExecuteSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String nameOfItem = "New Item";
        Item item = tracker.add(new Item(nameOfItem));
        FindIDAction findIDAction = new FindIDAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findIDAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Finding by Id ===" + ln
                + String.format("id: %s, name: %s, created: %s", item.getId(), item.getName(),
                FORMATTER.format(item.getCreated())) + ln));
    }

    @Test
    public void whenExecuteFailed() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String nameOfItem = "New Item";
        Item item = tracker.add(new Item(nameOfItem));
        FindIDAction findIDAction = new FindIDAction(out);
        Input input = mock(Input.class);
        findIDAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Finding by Id ===" + ln
                + "Item with requested Id is not found" + ln));
    }
}