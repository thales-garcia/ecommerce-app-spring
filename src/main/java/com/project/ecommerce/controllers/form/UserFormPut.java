package com.project.ecommerce.controllers.form;

import com.project.ecommerce.models.User;

import java.util.Objects;
import java.util.Optional;

public class UserFormPut {

    private Long id;
    private String name;
    private String email;

    public void converter(Optional<User> user) {
        user.get().setName(name);
        user.get().setEmail(email);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFormPut that = (UserFormPut) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
