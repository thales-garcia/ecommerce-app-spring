package com.project.ecommerce.controllers.form;

import com.project.ecommerce.models.Comments;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommentsForm {

    @NotNull @NotEmpty @Length(min=5)
    private String title;
    @NotNull @NotEmpty @Length(min=5)
    private String text;
    @NotNull
    private Double grade ;

    public CommentsForm(String title, String text,Double grade) {
        this.title = title;
        this.text = text;
        this.grade = grade;
    }

    public Double getGrade() {
        return grade;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Comments converter() {
        return new Comments(title, text, grade);
    }
}
