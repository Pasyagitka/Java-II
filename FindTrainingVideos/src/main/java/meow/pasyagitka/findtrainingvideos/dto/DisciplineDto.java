package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DisciplineDto {
    private int id;

    @NotEmpty(message = "Discipline name cannot be null")
    @Size(max=30, message = "Discipline name cannot be longer than 30 characters")
    private String name;
}


