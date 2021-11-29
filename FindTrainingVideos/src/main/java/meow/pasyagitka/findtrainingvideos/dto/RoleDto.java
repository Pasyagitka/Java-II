package meow.pasyagitka.findtrainingvideos.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoleDto {
    private Integer id;

    @NotEmpty(message = "Role name cannot be null")
    private String name;
}
