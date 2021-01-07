package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CompletedTaskController {

    private final TaskRepository taskRepository;

    public CompletedTaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
        @GetMapping("/completed-tasks")
    public String showCompletedTasks(Model model) {
            model.addAttribute("findAllCompleted",taskRepository.findAllCompeleted());
            return "task/completed-task-page";
    }
}
