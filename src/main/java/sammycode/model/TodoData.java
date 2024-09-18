package sammycode.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

//    === CONSTRUCTOR ====
    public TodoData(){

//        add some dummy data, using the addItem method 'so' it sets the id field
        addItem(new TodoItem("Adesire:[The Team Lead]","If you want to make the world a better place,take a look at yourself and then make a change-Batman", LocalDate.now()));
        addItem(new TodoItem("Azeez:[The Boss]","Be humble and never think that you're better than anyone....[For dust you're; and unto dust you shall return.]", LocalDate.now()));
        addItem(new TodoItem("Samuel:[The BigSam]","Computers & Internet Website", LocalDate.now()));
        addItem(new TodoItem("GodMan:[The TechGee]","One of the best skills to work on in your life is the ability to selfawere and understand yourself", LocalDate.now()));
        addItem(new TodoItem("Oluwafemi:[SammyCode]","[perssion meet career] The things you learn and skills you gain that are complitetly un-related to each other often compliment each other supricily ", LocalDate.now()));
        addItem(new TodoItem("JAVA:[Company backbone]","In the end work is work your technical ability is in your expacties don't matter as you think[what matters more:great and if you can get something done]", LocalDate.now()));
    }

// === public methods ==
    public List<TodoItem>getItems(){
        return Collections.unmodifiableList(items);
    }
    public void addItem(@NonNull TodoItem toAdd){
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }
    public void removeItem(int id){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if (item.getId() == id){
                itemIterator.remove();
                break;
            }
        }
    }
    public TodoItem getItem(int id){
        for (TodoItem item : items){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    public void updateItem( @NonNull TodoItem toUpdate){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if (item.equals(toUpdate)){
                itemIterator.set(toUpdate);
                break;
            }
        }
    }
}
