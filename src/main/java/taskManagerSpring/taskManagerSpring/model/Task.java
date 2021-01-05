package taskManagerSpring.taskManagerSpring.model;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity


@Table(name = "task")
public class Task {

    public Task() {
    }
    public Task(Long id, String title, @Size(min = 2, max = 200) String text, Status status, Expired expired) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.status = status;
        this.expired = expired;
    }

    public Task(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Size(min = 2, max = 200)
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "expired", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Expired expired;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Expired getExpired() {
        return expired;
    }

    public void setExpired(Expired expired) {
        this.expired = expired;
    }


}

