package taskManagerSpring.taskManagerSpring.service;

import org.springframework.stereotype.Service;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.ExpiredRepository;

import java.util.List;

@Service
public class ExpiredTaskService {
    private final ExpiredRepository expiredRepository;

    public ExpiredTaskService(ExpiredRepository expiredRepository) {
        this.expiredRepository = expiredRepository;
    }

    public List<Task> findAllSixHoursTasks() {
        return expiredRepository.findAllSixHoursTasks();
    }
    public List<Task> findAllTwelveHoursTasks() {
        return expiredRepository.findAllTwelveHoursTasks();
    }
    public List<Task> findAllOneDayTasks() {
        return expiredRepository.findAllOneDayTasks();
    }
    public List<Task> findAllTwoDaysTasks() {
        return expiredRepository.findAllTwoDaysTasks();
    }
    public List<Task> findAllWeekTasks() {
        return expiredRepository.findAllWeekTasks();
    }
    public List<Task> findAllMonthTasks() {
        return expiredRepository.findAllMonthTasks();
    }
}
