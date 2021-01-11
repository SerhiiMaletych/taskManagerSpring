package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;

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
