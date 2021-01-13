package taskManagerSpring.taskManagerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskManagerSpring.taskManagerSpring.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value= "SELECT * FROM task WHERE status ='IN_PROGRESS'", nativeQuery = true)
    String findAllInProgress();

    @Query(value= "SELECT * FROM task WHERE status ='COMPLETED'", nativeQuery = true)
    String findAllCompeleted();

    @Query(value= "SELECT * FROM task WHERE status = 'FAILED'", nativeQuery = true)
    String findAllFailed();
}
