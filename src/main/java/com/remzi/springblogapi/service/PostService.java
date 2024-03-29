package com.remzi.springblogapi.service;

import java.util.List;

import javax.validation.Valid;

import com.remzi.springblogapi.payload.PostDto;
import com.remzi.springblogapi.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> createPostAll(@Valid List<PostDto> postDto);

    // PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String
    // sortDir);

    // PostDto getPostById(long id);

    // PostDto updatePost(PostDto postDto, long id);

    // void deletePostById(long id);
}
