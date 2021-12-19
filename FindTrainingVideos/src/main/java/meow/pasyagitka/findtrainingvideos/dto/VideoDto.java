package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import meow.pasyagitka.findtrainingvideos.model.Discipline;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class VideoDto {
    private int id;

    @NotEmpty(message = "Title cannot be null")
    @Size(max=30, message = "Title cannot be longer than 30 characters")
    private String title;

    @NotEmpty(message = "Theme cannot be null")
    @Size(max=30, message = "Theme cannot be longer than 30 characters")
    private String theme;

    private Discipline disciplineEntity;

    @NotEmpty(message = "Author cannot be null")
    @Size(max=30, message = "Author cannot be longer than 30 characters")
    private String author;

    private Date date;

    @Size(max=30, message = "URL cannot be longer than 74 characters")
    @NotEmpty(message = "Video url cannot be null")
    private String url;

    @Size(max=30, message = "Description cannot be longer than 250 characters")
    private String description;

  /*  public void setDisciplineEntity(int DisciplineId) {
        this.disciplineEntity = disciplineEntity;
    }*/
}