package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteActionTest {

    @Test
    public void whenDeleteItemThenOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        store.add(new Item("test"));
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, store);
        String expected = """
                === Delete item ===
                Заявка удалена успешно
                """;
        assertThat(output.toString()).isEqualTo(expected);
        assertThat(store.findAll().size()).isEqualTo(0);
    }

    @Test
    public void whenDeleteItemThenNotOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        store.add(new Item("test"));
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        deleteAction.execute(input, store);
        String expected = """
                === Delete item ===
                Ошибка удаления заявки
                """;
        assertThat(output.toString()).isEqualTo(expected);
        assertThat(store.findAll().get(0).getName()).isEqualTo("test");
    }
}