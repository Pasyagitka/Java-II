package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AddVideoDto {
    @Size(max=100, message = "Max length of Title field is 100")
    @NotBlank(message = "Title is mandatory")
    private String title;

    @Size(max=100, message = "Max length of Theme field is 100")
    @NotBlank(message = "Theme is mandatory")
    private String theme;

    private int disciplineId;

    @Size(max=30, message = "Max length of Author field is 30")
    @NotBlank(message = "Author is mandatory")
    private String author;

    @Size(max=250, message = "Max length of URL field is 250")
    @NotBlank(message = "URL is mandatory")
    private String url;

    @Size(max=250, message = "Max length of Description field is 250")
    @NotBlank(message = "Description is mandatory")
    private String description;
}
