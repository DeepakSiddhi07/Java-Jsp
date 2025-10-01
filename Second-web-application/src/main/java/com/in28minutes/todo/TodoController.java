package com.in28minutes.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {
    //Set the login Service-Auto wiring
    @Autowired
    TodoService service ; //dependency injection

    @InitBinder
    protected  void  initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
    }

    @RequestMapping(value = "/list-todos",method = RequestMethod.GET )
    public String listTodos( ModelMap model){
//        model.addAttribute("name",name);
        model.addAttribute("todos",service.retrieveTodos(retriveLoggedinUserName()));
        return "list-todos";
    }

    private static String retriveLoggedinUserName() {
        return "in28Minutes";
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
    @RequestMapping(value = "/update-todo",method = RequestMethod.GET )
    public String updateTodo(ModelMap model,@RequestParam int id){
        Todo todo=service.retrieveTodo(id);
        model.addAttribute("todo",todo);
        return "todo";
    }
    @RequestMapping(value = "/update-todo",method = RequestMethod.POST )
    public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        todo.setUser("in28Minutes"); // Todo:Remove hard code
        //Update to do
        service.updateTodo(todo);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "/delete-todo",method = RequestMethod.GET )
    public String deleteTodo(ModelMap model,@RequestParam int id){
        service.deleteTodo(id);
        model.clear();
        return "redirect:list-todos";
    }


}
