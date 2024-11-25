package com.nexus.backend.domain.dtos;

import com.nexus.backend.domain.User;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected Long id;
    @NotNull(message = "the USER field is required")
    protected String username;
    @NotNull(message = "the PASSWORD field is required")
    protected String password;

    private boolean active = true;

    public UserDTO() { }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.username = obj.getUsername();
        this.password = obj.getPassword();
        this.active = obj.getActive();
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
