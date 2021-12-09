package com.project.ecommerce.controllers.form;

import com.project.ecommerce.models.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UserForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty @Length(min=5)
    private String name;
    @NotNull @NotEmpty @Length(min=5)
    private String email;
    @NotNull @NotEmpty @Length(min=5)
    private String password;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User converter() {
        return new User (name, email, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserForm userForm = (UserForm) o;
        return Objects.equals(getId(), userForm.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
