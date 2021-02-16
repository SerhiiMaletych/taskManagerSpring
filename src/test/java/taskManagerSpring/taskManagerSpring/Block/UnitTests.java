package taskManagerSpring.taskManagerSpring.Block;
import org.junit.jupiter.api.Test;
import taskManagerSpring.taskManagerSpring.model.Block;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTests {

    @Test
    public void setNameToBlock() {
        Block block = new Block("name");
        assertThat(block.getName()).isEqualTo("name");

    }

    @Test
    public void getAllFieldsOfBlock() {
        Block block = new Block(100L,"some name");
        assertThat(block.getId()).isEqualTo(100L);
        assertThat(block.getName()).isEqualTo("some name");
    }

    @Test
    public void createBlockThenChangeName() {
        Block block = new Block(100L,"some name");
        block.setName("another name");
        assertThat(block.getName()).isEqualTo("another name");

    }
}
