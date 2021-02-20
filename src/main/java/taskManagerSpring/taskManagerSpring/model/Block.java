package taskManagerSpring.taskManagerSpring.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "block")
public class Block {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @javax.persistence.Column(name = "name", nullable = false)
    private String name;

    public Block(String name) {
        this.name = name;
    }



}
