package com.project.ecommerce.controllers.form;

import com.project.ecommerce.models.Comments;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

public class CommentsFormPut {

    @NotNull @NotEmpty @Length(min=5)
    private String title;
    @NotNull @NotEmpty @Length(min=5)
    private String text;
    @NotNull
    private Double grade;

    public void converter(Optional<Comments> com) {
        com.get().setTitle(title);
        com.get().setText(text);
        com.get().setGrade(grade);
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsFormPut that = (CommentsFormPut) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
