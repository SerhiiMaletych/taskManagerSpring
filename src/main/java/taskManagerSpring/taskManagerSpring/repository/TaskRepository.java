package taskManagerSpring.taskManagerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskManagerSpring.taskManagerSpring.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value= "SELECT * FROM task WHERE expired ='IN_PROGRESS'", nativeQuery = true)
    String findAllInProgress();

    @Query(value= "SELECT * FROM task WHERE expired ='DONE'", nativeQuery = true)
    String findAllDone();

    @Query(value= "SELECT * FROM task WHERE expired ='FAILED'", nativeQuery = true)
    String findAllFailed();
}
