package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    public void whenFindOneItemByNameThenOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item test1 = new Item("test1");
        Item test2 = new Item("test2");
        store.add(test1);
        store.add(test2);
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("test1");
        findByNameAction.execute(input, store);
        String expected = String.format("""
                === Find items by name ===
                %s
                """, test1);
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    public void whenFindSeveralItemsByNameThenOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item test1 = new Item("test1");
        Item test2 = new Item("test1");
        store.add(test1);
        store.add(test2);
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("test1");
        findByNameAction.execute(input, store);
        String expected = String.format("""
                === Find items by name ===
                %s
                %s
                """, test1, test2);
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    public void whenFindItemByNameThenNotOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item test = new Item("test");
        store.add(test);
        FindByNameAction findByNameAction = new FindByNameAction(output);
        String searchName = "test1";
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(searchName);
        findByNameAction.execute(input, store);
        String expected = String.format("""
                === Find items by name ===
                Заявки с именем: %s не найдены
                """, searchName);
        assertThat(output.toString()).isEqualTo(expected);
    }
}