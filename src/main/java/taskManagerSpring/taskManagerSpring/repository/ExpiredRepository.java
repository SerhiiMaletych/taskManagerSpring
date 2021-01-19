package taskManagerSpring.taskManagerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import taskManagerSpring.taskManagerSpring.model.Task;

import java.util.List;

public interface ExpiredRepository extends JpaRepository<Task, Long> {


    @Query(value = "SELECT * FROM task WHERE expired like 'HOURS_6' AND status like 'IN_PROGRESS'",
            nativeQuery = true)
    List<Task> findAllSixHoursTasks();

    @Query(value = "SELECT * FROM task WHERE expired like 'HOURS_12' AND status like 'IN_PROGRESS'",
            nativeQuery = true)
    List<Task> findAllTwelveHoursTasks();

    @Query(value = "SELECT * FROM task WHERE expired like 'ONE_DAY' AND status like 'IN_PROGRESS'",
            nativeQuery = true)
    List<Task> findAllOneDayTasks();

    @Query(value = "SELECT * FROM task WHERE expired like 'TWO_DAYS' AND status like 'IN_PROGRESS'",
            nativeQuery = true)
    List<Task> findAllTwoDaysTasks();

    @Query(value = "SELECT * FROM task WHERE expired like 'ONE_WEEK' AND status like 'IN_PROGRESS'",
            nativeQuery = true)
    List<Task> findAllWeekTasks();

    @Query(value = "SELECT * FROM task WHERE expired like 'ONE_MONTH' AND status like 'IN_PROGRESS'",
            nativeQuery = true)
    List<Task> findAllMonthTasks();
}
