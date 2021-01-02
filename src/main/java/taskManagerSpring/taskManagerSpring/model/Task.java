package taskManagerSpring.taskManagerSpring.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text")
    private String text;
}
