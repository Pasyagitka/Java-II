package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import meow.pasyagitka.findtrainingvideos.validator.Password;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Size(min=2, max=50, message = "Login must contain from 2 to 50 characters")
    private String login;

    @Column
    @Password(message = "{valid.password.password}")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleEntity;
}