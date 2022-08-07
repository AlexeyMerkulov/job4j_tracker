package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EditActionTest {

    @Test
    public void whenExecuteSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String nameOfItem = "Replaced item";
        tracker.add(new Item(nameOfItem));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Editing an Item ===" + ln
                + "The item was successfully replaced" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenExecuteFailed() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String nameOfItem = "Replaced item";
        tracker.add(new Item(nameOfItem));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);
        Input input = mock(Input.class);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Editing an Item ===" + ln
                + "Error! Id was not found" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(nameOfItem));
    }
}