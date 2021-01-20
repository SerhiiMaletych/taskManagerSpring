package taskManagerSpring.taskManagerSpring;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import taskManagerSpring.taskManagerSpring.model.Expired;
import taskManagerSpring.taskManagerSpring.model.Status;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.ExpiredRepository;

public class UnitTests {
    private final ExpiredRepository expiredRepository;

    public UnitTests(ExpiredRepository expiredRepository) {
        this.expiredRepository = expiredRepository;
    }

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
        Task task = new Task(10L, "Title", "some_text", Status.COMPLETED, Expired.HOURS_12, "20/01/2021 15:34:58");

        assertThat(task.getId()).isEqualTo(10L);
        assertThat(task.getTitle()).isEqualTo("Title");
        assertThat(task.getText()).isEqualTo("some_text");
        assertThat(task.getStatus()).isEqualTo(Status.COMPLETED);
        assertThat(task.getExpired()).isEqualTo(Expired.HOURS_12);
        assertThat(task.getDate()).isEqualTo("20/01/2021 15:34:58");
    }

    @Test
    public void changeStatusOfTheTask() {
        Task task = new Task(10L, "Title", "some_text", Status.COMPLETED, Expired.HOURS_12, "20/01/2021 15:34:58");
        task.setStatus(Status.IN_PROGRESS);
        assertThat(task.getStatus()).isEqualTo(Status.IN_PROGRESS);

    }

    @Test
    public void changeExpiredTimeForTheTask() {
        Task task = new Task(10L, "Title", "some_text", Status.COMPLETED, Expired.HOURS_12, "20/01/2021 15:34:58");
        task.setExpired(Expired.HOURS_6);
        assertThat(task.getExpired()).isEqualTo(Expired.HOURS_6);

    }

    @Test
    public void changeTextOfTheTask() {
        Task task = new Task(10L, "Title", "some_text", Status.COMPLETED, Expired.HOURS_12, "20/01/2021 15:34:58");
        task.setText("new text");
        assertThat(task.getText()).isEqualTo("new text");

    }



}