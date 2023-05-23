package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EditActionTest {

    @Test
    public void whenEditItemThenOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        store.add(new Item("test"));
        String replacedName = "newTest";
        EditAction editAction = new EditAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        editAction.execute(input, store);
        String expected = """
                === Edit item ===
                Заявка заменена успешно
                """;
        assertThat(output.toString()).isEqualTo(expected);
        assertThat(store.findAll().get(0).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenEditItemThenNotOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        store.add(new Item("test"));
        String replacedName = "newTest";
        EditAction editAction = new EditAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        editAction.execute(input, store);
        String expected = """
                === Edit item ===
                Ошибка замены заявки
                """;
        assertThat(output.toString()).isEqualTo(expected);
        assertThat(store.findAll().get(0).getName()).isEqualTo("test");
    }
}