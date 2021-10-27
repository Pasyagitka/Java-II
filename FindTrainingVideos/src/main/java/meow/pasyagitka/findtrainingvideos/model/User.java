package meow.pasyagitka.findtrainingvideos.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import meow.pasyagitka.findtrainingvideos.validator.Password;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*@Getter
@Setter*/
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(Role roleEntity) {
        this.roleEntity = roleEntity;
    }
}