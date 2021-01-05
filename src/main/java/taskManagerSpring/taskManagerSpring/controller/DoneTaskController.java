package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;

@Controller
public class DoneTaskController {

    private final TaskRepository taskRepository;

    public DoneTaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
        @GetMapping("/done-tasks")
    public String showDoneTasks(Model model) {
    model.addAttribute("findAllDone",taskRepository.findAllDone());
    return "task/done-task-page";
    }
}
