package taskManagerSpring.taskManagerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskManagerSpring.taskManagerSpring.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
