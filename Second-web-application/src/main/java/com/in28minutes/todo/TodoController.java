package com.in28minutes.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {
    //Set the login Service-Auto wiring
    @Autowired
    TodoService service ; //dependency injection

    @RequestMapping(value = "/list-todos",method = RequestMethod.GET )
    public String listTodos( ModelMap model){
//        model.addAttribute("name",name);
        model.addAttribute("todos",service.retrieveTodos("in28Minutes"));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET )
    public String showLoginPage(ModelMap model){
        model.addAttribute("todo",new Todo(1, false, new Date(), "in28Minutes", ""));

        return "todo";
    }
    @RequestMapping(value = "/add-todo",method = RequestMethod.POST )
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        service.addTodo("in28Minutes",todo.getDesc(),new Date(),false);
         model.clear();
        return "redirect:list-todos";
    }
    @RequestMapping(value = "/delete-todo",method = RequestMethod.GET )
    public String deleteTodo(ModelMap model,@RequestParam int id){
        service.deleteTodo(id);
        model.clear();
        return "redirect:list-todos";
    }


}
