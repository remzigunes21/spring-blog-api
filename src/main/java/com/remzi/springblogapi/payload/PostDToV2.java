package com.remzi.springblogapi.payload;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PostDToV2 {

    private Long id;
    // tittle should not be null or empty
    // title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters.")
    private String title;
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters.")
    private String description;
    @NotEmpty
    private String content;
    private Set<CommentDTO> comments;

    private List<String> tags;

}
