package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taskManagerSpring.taskManagerSpring.exception.EmptyListException;
import taskManagerSpring.taskManagerSpring.service.TaskService;

@Controller
public class FailedTaskController {
   private final TaskService taskService;

    public FailedTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/failed-tasks")
    public String showFailedTasks(Model model) throws EmptyListException {
        model.addAttribute("findAllFailed",taskService.findAllFailed());
        if(taskService.findAllFailed().isEmpty()) {
            throw new EmptyListException("It's empty here, create some task!");
        }
        return "task/failed-task-page";
    }
}
