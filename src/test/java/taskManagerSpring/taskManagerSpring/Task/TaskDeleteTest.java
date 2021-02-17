package taskManagerSpring.taskManagerSpring.Task;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import taskManagerSpring.taskManagerSpring.model.Expired;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;
import taskManagerSpring.taskManagerSpring.service.TaskService;


import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)

public class TaskDeleteTest {

    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void deleteTask() {
        Task task = new Task(10L, "Title", "some_text", Status.COMPLETED, Expired.HOURS_12, "20/01/2021 15:34:58");

        when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));
        taskService.deleteById(task.getId());
        verify(taskRepository).deleteById(task.getId());
    }

}
