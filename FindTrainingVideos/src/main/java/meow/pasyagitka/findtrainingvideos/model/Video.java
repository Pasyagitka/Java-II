package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Videos")
@Data
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String theme;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline disciplineEntity;

    @Column
    private String author;

    @Column
    private Date date;

    @Column
    private String url;

    @Column
    private String description;
}