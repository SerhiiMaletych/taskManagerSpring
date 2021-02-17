package taskManagerSpring.taskManagerSpring.Block;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import taskManagerSpring.taskManagerSpring.model.Block;
import taskManagerSpring.taskManagerSpring.model.Expired;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.BlockRepository;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;
import taskManagerSpring.taskManagerSpring.service.BlockService;
import taskManagerSpring.taskManagerSpring.service.TaskService;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
public class BlockDeleteTest {

    @InjectMocks
    BlockService blockService;

    @Mock
    BlockRepository blockRepository;

    @Test
    public void deleteBlock() {
        Block block = new Block(100L,"some name");

        when(blockRepository.findById(block.getId())).thenReturn(Optional.of(block));
        blockService.deleteById(block.getId());
        verify(blockRepository).deleteById(block.getId());
    }
}
