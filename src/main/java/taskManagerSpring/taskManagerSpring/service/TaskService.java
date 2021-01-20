package taskManagerSpring.taskManagerSpring.service;

import org.springframework.stereotype.Service;
import taskManagerSpring.taskManagerSpring.model.Expired;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        setExpiredDate(task, formatter, date);
    }


    public void updateTask (Task task) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        setExpiredDate(task, formatter, date);
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    private void setExpiredDate(Task task, SimpleDateFormat formatter, Date date) {
        if(task.getExpired()== Expired.HOURS_6) {
            task.setExpiredDate(formatter.format(addHoursToJavaUtilDate(date, 6)));
        }
        else if(task.getExpired()==Expired.HOURS_12){
            task.setExpiredDate(formatter.format(addHoursToJavaUtilDate(date, 12)));
        }
        else if(task.getExpired()==Expired.ONE_DAY){
            task.setExpiredDate(formatter.format(addHoursToJavaUtilDate(date, 24)));
        }
        else if(task.getExpired()==Expired.TWO_DAYS){
            task.setExpiredDate(formatter.format(addHoursToJavaUtilDate(date, 48)));
        }
        else if(task.getExpired()==Expired.ONE_WEEK){
            task.setExpiredDate(formatter.format(addHoursToJavaUtilDate(date, 168)));
        }
        else if(task.getExpired()==Expired.ONE_MONTH){
            task.setExpiredDate(formatter.format(addHoursToJavaUtilDate(date, 720)));
        }
        taskRepository.save(task);
    }
}
