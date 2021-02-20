package taskManagerSpring.taskManagerSpring.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "task")
public class Task {


    public Task(Long id, String title, @Size(min = 2, max = 200) String text, Status status, Expired expired, String date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.status = status;
        this.expired = expired;
        this.date = date;

    }

    public Task(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Size(min = 1, max = 200)
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



}

