package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taskManagerSpring.taskManagerSpring.exception.EmptyListException;
import taskManagerSpring.taskManagerSpring.service.TaskService;

@Controller
public class CompletedTaskController {

    private final TaskService taskService;

    public CompletedTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/completed-tasks")
    public String showCompletedTasks(Model model) throws EmptyListException {
            model.addAttribute("findAllCompleted",taskService.findAllCompleted());
        if(taskService.findAllCompleted().isEmpty()) {
            throw new EmptyListException("It's empty here, create some task!");
        }
            return "task/completed-task-page";
    }


}
