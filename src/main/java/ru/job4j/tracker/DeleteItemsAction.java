package ru.job4j.tracker;

public class DeleteItemsAction implements UserAction {
    private final Output out;

    public DeleteItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete multiple Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int counter = 0;
        out.println("=== Delete multiple Items ===");
        int id = input.askInt("Enter start id: ");
        int count = input.askInt("How many Items delete: ");
        for (int i = 0; i < count; i++) {
            if (tracker.delete(id++)) {
                counter++;
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        out.println("Заявок удалено успешно: " + counter);
        return true;
    }
}
