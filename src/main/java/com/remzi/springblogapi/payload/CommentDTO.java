package com.remzi.springblogapi.payload;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Comment model information", value = "Comment")
public class CommentDTO {

	@ApiModelProperty(value = "Comment id")
	private long id;
	// name should not be null or empty
	@ApiModelProperty(value = "Comment name")
	@NotEmpty(message = "Name should not be null or empty")
	private String name;

	// email should not be null or empty
	// email field validation
	@ApiModelProperty(value = "Comment email")
	@NotEmpty(message = "Email should not be null or empty")
	@Email
	private String email;

	// comment body should not be bull or empty
	// Comment body must be minimum 10 characters
	@NotEmpty
	@ApiModelProperty(value = "Comment body")
	@Size(min = 10, message = "Comment body must be minimum 10 characters")
	private String body;

	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDTO(long id, @NotEmpty(message = "Name should not be null or empty.") String name,
			@NotEmpty(message = "Email should not be null or empty.") @Email String email,
			@NotEmpty(message = "Comment should not be null or empty.") @Size(min = 10, message = "Comment should not be null or empty.") String body) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDTO other = (CommentDTO) obj;
		return id == other.id;
	}

}
