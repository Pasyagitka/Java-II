package meow.pasyagitka.findtrainingvideos.dto;


import javax.validation.constraints.NotEmpty;

public class RoleDto {
    private Integer id;

    @NotEmpty(message = "Role name cannot be null")
    private String name;
}
