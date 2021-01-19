package taskManagerSpring.taskManagerSpring.service;

import org.springframework.stereotype.Service;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task>findAllFailed() {
        return taskRepository.findAllFailed();
    }
    public List<Task>findAllCompleted() {
        return taskRepository.findAllCompleted();
    }
    public List<Task>findAllInProgress() {
        return taskRepository.findAllInProgress();
    }


    public void createTask(Task task) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        task.setDate(formatter.format(date));
        task.setStatus(Status.IN_PROGRESS);
        taskRepository.save(task);
    }


}
