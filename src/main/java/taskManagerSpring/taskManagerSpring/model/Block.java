package taskManagerSpring.taskManagerSpring.model;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "block")
public class Block {

    public Block() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Block(String name) {
        this.name = name;
    }

    @javax.persistence.Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
