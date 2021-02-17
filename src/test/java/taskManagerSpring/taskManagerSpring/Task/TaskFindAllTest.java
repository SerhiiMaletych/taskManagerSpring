package taskManagerSpring.taskManagerSpring.Task;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.TaskRepository;
import taskManagerSpring.taskManagerSpring.service.TaskService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
public class TaskFindAllTest {

    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void findAllTasks() {
        List<Task> task = new ArrayList();
        task.add(new Task());
        task.add(new Task());
        task.add(new Task());
        given(taskRepository.findAll()).willReturn(task);
        List<Task> expected = taskService.findAll();
        assertEquals(expected, task);
        verify(taskRepository).findAll();
    }
}
