package taskManagerSpring.taskManagerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskManagerSpring.taskManagerSpring.model.Block;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {
}
