package com.remzi.springblogapi.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CommentDTO {

    private long id;

    @NotEmpty(message = "Name should not be null or empty.")
    private String name;

    @NotEmpty(message = "Email should not be null or empty.")
    @Email
    private String email;

    @NotEmpty(message = "Comment should not be null or empty.")
    @Size(min = 10, message = "Comment should not be null or empty.")
    private String body;

}
