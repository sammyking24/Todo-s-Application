package sammycode.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import sammycode.model.TodoData;
import sammycode.model.TodoItem;

@Service
public class ToDoItemServiceImpl implements TodoItemService{

//    === FIELDS ===
    @Getter
    private final TodoData data = new TodoData();

//    ===PUBLIC  METHODS===
    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);

    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);

    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);

    }
}
