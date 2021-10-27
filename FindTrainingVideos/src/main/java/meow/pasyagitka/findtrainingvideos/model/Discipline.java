package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Disciplines")
@Data
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

