package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "Disciplines")
@Data
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty(message = "Discipline name cannot be null")
    @Size(max=30, message = "Discipline name cannot be longer than 30 characters")
    private String name;
}

