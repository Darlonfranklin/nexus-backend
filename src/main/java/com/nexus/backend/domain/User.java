package com.nexus.backend.domain;
import com.nexus.backend.domain.dtos.UserDTO;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean active;

    public User() {}

    public User(Long id, String username, String password, boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public User(UserDTO obj) {
        this.id = obj.getId();
        this.username = obj.getUsername();
        this.password = obj.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
