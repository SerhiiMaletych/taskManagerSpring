package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;

@Controller
public class FailedTaskController {
    private final TaskRepository taskRepository;

    public FailedTaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/failed-tasks")
    public String showFailedTasks(Model model) {
        model.addAttribute("findAllFailed",taskRepository.findAllFailed());
        return "task/failed-task-page";
    }
}
