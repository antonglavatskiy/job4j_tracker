package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByIdActionTest {

    @Test
    public void whenFindItemByIdThenOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item test = new Item("test");
        store.add(test);
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findByIdAction.execute(input, store);
        String expected = String.format("""
                === Find item by id ===
                %s
                """, test);
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    public void whenFindItemByIdThenNotOk() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item test = new Item("test");
        store.add(test);
        FindByIdAction findByIdAction = new FindByIdAction(output);
        int searchId = 2;
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(searchId);
        findByIdAction.execute(input, store);
        String expected = String.format("""
                === Find item by id ===
                Заявка с введенным id: %d не найдена
                """, searchId);
        assertThat(output.toString()).isEqualTo(expected);
    }

}