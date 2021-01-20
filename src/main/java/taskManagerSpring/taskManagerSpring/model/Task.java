package taskManagerSpring.taskManagerSpring.model;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;


@Entity
@DynamicUpdate
@Table(name = "task")
public class Task {

    public Task() {
    }
    public Task(Long id, String title, @Size(min = 2, max = 200) String text, Status status, Expired expired,String date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.status = status;
        this.expired = expired;
        this.date=date;

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

    @Column(name = "date", unique = true, updatable = false)
    private String date;




    @Column(name = "expireddate")
    private String expiredDate;


    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}

