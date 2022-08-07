package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenExecuteSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String itemName = "New item";
        tracker.add(new Item(itemName));
        DeleteAction deleteAction = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Deleting an Item ===" + ln
                + "The item was successfully deleted" + ln));
        assertTrue(tracker.findAll().isEmpty());
    }

    @Test
    public void whenExecuteFailed() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String itemName = "New item";
        tracker.add(new Item(itemName));
        DeleteAction deleteAction = new DeleteAction(out);
        Input input = mock(Input.class);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Deleting an Item ===" + ln
                + "Error! Id was not found" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(itemName));
    }
}