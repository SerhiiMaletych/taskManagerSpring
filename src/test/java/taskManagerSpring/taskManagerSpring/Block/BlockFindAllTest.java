package taskManagerSpring.taskManagerSpring.Block;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import taskManagerSpring.taskManagerSpring.model.Block;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.BlockRepository;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;
import taskManagerSpring.taskManagerSpring.service.BlockService;
import taskManagerSpring.taskManagerSpring.service.TaskService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
public class BlockFindAllTest {

    @InjectMocks
    BlockService blockService;

    @Mock
    BlockRepository blockRepository;

    @Test
    public void findAllBlocks() {
        List<Block> blocks = new ArrayList();
        blocks.add(new Block());
        blocks.add(new Block());
        blocks.add(new Block());
        given(blockRepository.findAll()).willReturn(blocks);
        List<Block> expected = blockService.findAll();
        assertEquals(expected, blocks);
        verify(blockRepository).findAll();
    }
}
