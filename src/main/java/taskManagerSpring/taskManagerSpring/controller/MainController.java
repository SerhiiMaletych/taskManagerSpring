package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;
import taskManagerSpring.taskManagerSpring.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

       private final TaskService taskService;
       private final TaskRepository taskRepository;

    public MainController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }


    @GetMapping("task-create")
    public String createForm(Task task) {
        return "task/task-create-page";

    }
    @PostMapping("task-create")
    public String createTask(Task task, Model model){
        taskService.createTask(task);
        model.addAttribute("status", Status.values());
        return "redirect:/";
    }


    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("task", task);
        return "task/task-update-page";
    }

    @PostMapping("/task-update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Task task, BindingResult result, Model model) {
     if (result.hasErrors()) {
        task.setId(id);
        return "task/task-update-page";
    }

    taskRepository.save(task);

    return "redirect:/";
}

    @GetMapping("/")
    public String findAllTasks(Model model) {
        List<Task> task = taskService.findAll();
        model.addAttribute("task", task);
        return "task/task-list-page";

    }


    @GetMapping("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        taskRepository.delete(task);
        return "redirect:/";
    }





}
