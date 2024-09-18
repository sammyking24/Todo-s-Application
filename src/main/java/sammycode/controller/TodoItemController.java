package sammycode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sammycode.model.TodoData;
import sammycode.model.TodoItem;
import sammycode.service.TodoItemService;
import sammycode.util.AttributeNames;
import sammycode.util.Mappings;
import sammycode.util.ViewNames;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

//    ===fields===
    private final TodoItemService todoItemService;

//    ===constructor====
@Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    //    ===== ModelAttributes ====
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

//     ===  Handler methods ===
//    http://localhoste:8080/TodoList/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }
    @GetMapping(Mappings.ADD_ITEM)
    public String getItem(@RequestParam(required = false, defaultValue = "-1")int id,
                              Model model){

    log.info("editing id = {}", id);
    TodoItem todoItem = new TodoItem("","", LocalDate.now());


    model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
    return ViewNames.ADD_ITEM;
    }
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
    log.info("todoItem from from = {}", todoItem);

    if (todoItem.getId() == 0){
        todoItemService.addItem(todoItem);
    }else {
        todoItemService.updateItem(todoItem);
    }

    return "redirect:/" + Mappings.ITEMS;

    }
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
         log.info("Deleting item with id={}", id);
         todoItemService.removeItem(id);
         return "redirect:/" + Mappings.ITEMS;

    }
    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;

    }
}
