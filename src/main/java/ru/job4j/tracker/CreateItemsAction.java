package ru.job4j.tracker;

public class CreateItemsAction implements UserAction {
    private final Output out;

    public CreateItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add multiple Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create multiple Items ===");
        int count = input.askInt("How many Items create: ");
        for (int i = 0; i < count; i++) {
            Item item = new Item("Item " + i);
            tracker.add(item);
            out.println("Добавленная заявка: " + item);
        }
        out.println("Создано " +  count + " заявок");
        return true;
    }
}
