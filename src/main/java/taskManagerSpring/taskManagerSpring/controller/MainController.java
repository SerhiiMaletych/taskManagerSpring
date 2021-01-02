package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.service.TaskService;

import java.util.List;

@Controller
public class MainController {

       private final TaskService taskService;

    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }



    @GetMapping("task-create")
    public String createForm(Task task) {
        return "task/task-create-page";

    }
    @PostMapping("task-create")
    public String createTask(Task task, Model model){
        taskService.saveTask(task);
        model.addAttribute("status", Status.values());
        return "redirect:/";
    }

    @PostMapping("/task-update")
    public String updateTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }


    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model) throws Exception {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "task/task-update-page";
    }

    @GetMapping("/")
    public String findAllTasks(Model model) {
        List<Task> task = taskService.findAll();
        model.addAttribute("task", task);
        return "task/task-list-page";

    }


    @GetMapping("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return "redirect:/";
    }





}
