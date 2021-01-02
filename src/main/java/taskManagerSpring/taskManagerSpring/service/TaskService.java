package taskManagerSpring.taskManagerSpring.service;

import org.springframework.stereotype.Service;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findById(Long id) {
        return taskRepository.getOne(id);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }


}
