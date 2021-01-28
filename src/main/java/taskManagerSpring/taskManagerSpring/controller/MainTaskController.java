package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import taskManagerSpring.taskManagerSpring.model.Block;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.ExpiredRepository;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;
import taskManagerSpring.taskManagerSpring.service.BlockService;
import taskManagerSpring.taskManagerSpring.service.ExpiredTaskService;
import taskManagerSpring.taskManagerSpring.service.TaskService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class MainTaskController {

    private final TaskService taskService;
    private final TaskRepository taskRepository;
    private final ExpiredTaskService expiredTaskService;
    private final BlockService blockService;

    public MainTaskController(TaskService taskService, TaskRepository taskRepository, ExpiredRepository expiredRepository, ExpiredTaskService expiredTaskService, BlockService blockService) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;

        this.expiredTaskService = expiredTaskService;
        this.blockService = blockService;
    }

    @GetMapping("/all-tasks")
    public String findAllTasks(Model model) {
        List<Task> task = taskService.findAll();
        model.addAttribute("task", task);

        return "task/all-tasks-page";

    }


    @GetMapping("task-create")
    public String createForm(Task task) {
        return "task/task-create-page";

    }

    @PostMapping("task-create")
    public String createTask(Task task, Model model) {
        taskService.createTask(task);
        model.addAttribute("status", Status.values());
        return "redirect:/";
    }


    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model) throws ParseException {
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("task", task);

        return "task/task-update-page";
    }

    @PostMapping("/task-update/{id}")
    public String updateTask(@PathVariable("id") long id, @Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            task.setId(id);
            return "task/task-update-page";
        }

        taskService.updateTask(task);

        return "redirect:/";
    }

    @GetMapping("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        taskRepository.delete(task);
        return "redirect:/";
    }

    @GetMapping("/")
    public String findAllCompletedTasks(Model model) {
        model.addAttribute("findAllInProgress", taskService.findAllInProgress());
        model.addAttribute("sixHours", expiredTaskService.findAllSixHoursTasks());
        model.addAttribute("twelveHours", expiredTaskService.findAllTwelveHoursTasks());
        model.addAttribute("oneDay", expiredTaskService.findAllOneDayTasks());
        model.addAttribute("twoDays", expiredTaskService.findAllTwoDaysTasks());
        model.addAttribute("oneWeek", expiredTaskService.findAllWeekTasks());
        model.addAttribute("oneMonth", expiredTaskService.findAllMonthTasks());
        List<Block> block = blockService.findAll();
        model.addAttribute("block", block);
        return "task/task-list-page";

    }


}
