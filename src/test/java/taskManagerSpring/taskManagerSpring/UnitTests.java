package taskManagerSpring.taskManagerSpring;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import taskManagerSpring.taskManagerSpring.model.Expired;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;

public class UnitTests {

    @Test
    public void getRightTitleOfTask() {
        Task task = new Task("Title");
        assertThat(task.getTitle()).isEqualTo("Title");
    }

    @Test
    public void setRightTitleOfTask() {
        Task task = new Task("Title");
        task.setTitle("Another_title");
        assertThat(task.getTitle()).isEqualTo("Another_title");
    }

    @Test
    public void getAllFieldsOfTask() {
        Task task = new Task(10L, "Title", "some_text", Status.DONE, Expired.HOURS_12);

        assertThat(task.getId()).isEqualTo(10L);
        assertThat(task.getTitle()).isEqualTo("Title");
        assertThat(task.getText()).isEqualTo("some_text");
        assertThat(task.getStatus()).isEqualTo(Status.DONE);
        assertThat(task.getExpired()).isEqualTo(Expired.HOURS_12);
    }
}
