package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Videos")
@Data
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty(message = "Title cannot be null")
    @Size(max=30, message = "Title cannot be longer than 30 characters")
    private String title;

    @Column
    @NotEmpty(message = "Theme cannot be null")
    @Size(max=30, message = "Theme cannot be longer than 30 characters")
    private String theme;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline disciplineEntity;

    @Column
    @NotEmpty(message = "Author cannot be null")
    @Size(max=30, message = "Author cannot be longer than 30 characters")
    private String author;

    @Column
    private Date date;

    @Column
    @Size(max=30, message = "URL cannot be longer than 74 characters")
    @NotEmpty(message = "Video url cannot be null")
    private String url;

    @Column
    @Size(max=30, message = "Description cannot be longer than 250 characters")
    private String description;
}