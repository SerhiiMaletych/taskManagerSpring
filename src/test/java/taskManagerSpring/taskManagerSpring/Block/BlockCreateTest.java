package taskManagerSpring.taskManagerSpring.Block;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taskManagerSpring.taskManagerSpring.model.Block;
import taskManagerSpring.taskManagerSpring.service.BlockService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
public class BlockCreateTest {
    @Autowired
    BlockService blockService;
    @Test
    public void addUser() {
        Block block = new Block();
        block.setId(101L);
        block.setName("name");

        boolean isCreated = blockService.saveBlock(block);
        Assert.assertTrue(isCreated);
    }

}
