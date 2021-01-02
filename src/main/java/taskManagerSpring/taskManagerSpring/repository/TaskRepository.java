package taskManagerSpring.taskManagerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskManagerSpring.taskManagerSpring.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
