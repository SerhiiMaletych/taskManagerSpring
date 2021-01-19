package taskManagerSpring.taskManagerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import taskManagerSpring.taskManagerSpring.model.Task;

import java.util.List;

public interface ExpiredRepository extends JpaRepository<Task, Long> {


    @Query(value = "SELECT * FROM task WHERE expired = 'HOURS_6'", nativeQuery = true)
    List<Task> findAllSixHoursTasks();

    @Query(value = "SELECT * FROM task WHERE expired = 'HOURS_6'", nativeQuery = true)
    List<Task> findAllTwelveHoursTasks();

    @Query(value = "SELECT * FROM task WHERE expired = 'ONE_DAY'", nativeQuery = true)
    List<Task> findAllOneDayTasks();

    @Query(value = "SELECT * FROM task WHERE expired = 'TWO_DAYS'", nativeQuery = true)
    List<Task> findAllTwoDaysTasks();

    @Query(value = "SELECT * FROM task WHERE expired = 'ONE_WEEK'", nativeQuery = true)
    List<Task> findAllWeekTasks();

    @Query(value = "SELECT * FROM task WHERE expired = 'ONE_MONTH'", nativeQuery = true)
    List<Task> findAllMonthTasks();
}
