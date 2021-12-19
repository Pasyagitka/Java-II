package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Data;

@Data
public class AddVideoDto {
    private String title;
    private String theme;
    private int disciplineId;
    private String author;
    private String url;
    private String description;
}
