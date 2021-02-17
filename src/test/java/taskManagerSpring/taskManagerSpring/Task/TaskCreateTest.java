package taskManagerSpring.taskManagerSpring.Task;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taskManagerSpring.taskManagerSpring.model.Expired;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.service.TaskService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
public class TaskCreateTest {
    @Autowired
    TaskService taskService;


    @Test
    void addTask() {

        Task task = new Task(10L, "Title", "some_text",
                Status.COMPLETED, Expired.HOURS_12, "20/01/2021 15:34:58");
        boolean isCreated = taskService.createTask(task);
        Assert.assertTrue(isCreated);
    }
}
