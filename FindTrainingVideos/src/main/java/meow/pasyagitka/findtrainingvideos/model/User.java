package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;
import meow.pasyagitka.findtrainingvideos.validator.Password;

import javax.persistence.*;


@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String login;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleEntity;
}