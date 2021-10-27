package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Videos")
@Data
public class Video {
    //todo только один тип связей

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Discipline getDisciplineEntity() {
        return disciplineEntity;
    }

    public void setDisciplineEntity(Discipline disciplineEntity) {
        this.disciplineEntity = disciplineEntity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}