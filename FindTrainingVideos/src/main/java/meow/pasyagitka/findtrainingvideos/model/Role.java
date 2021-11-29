package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "Roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
}