package taskManagerSpring.taskManagerSpring;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taskManagerSpring.taskManagerSpring.controller.BlockController;
import taskManagerSpring.taskManagerSpring.controller.CompletedTaskController;
import taskManagerSpring.taskManagerSpring.controller.FailedTaskController;
import taskManagerSpring.taskManagerSpring.controller.MainTaskController;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTestsForNotNull {

    @Autowired
    BlockController blockController;

    @Autowired
    CompletedTaskController completedTaskController;

    @Autowired
    FailedTaskController failedTaskController;

    @Autowired
    MainTaskController mainTaskController;

    @Test
    public void BlockControllerNotNull() {
        assertThat(blockController).isNotNull();
    }
    @Test
    public void CompletedTaskControllerNotNull() {
        assertThat(completedTaskController).isNotNull();
    }
    @Test
    public void FailedTaskControllerNotNull() {
        assertThat(failedTaskController).isNotNull();
    }
    @Test
    public void MainTaskControllerNotNull() {
        assertThat(mainTaskController).isNotNull();
    }


}
