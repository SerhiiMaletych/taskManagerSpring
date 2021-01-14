package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taskManagerSpring.taskManagerSpring.service.TaskService;

@Controller
public class CompletedTaskController {

    private final TaskService taskService;

    public CompletedTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/completed-tasks")
    public String showCompletedTasks(Model model) {
            model.addAttribute("findAllCompleted",taskService.findAllCompleted());
            return "task/completed-task-page";
    }


}
