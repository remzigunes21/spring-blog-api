package com.remzi.springblogapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.remzi.springblogapi.payload.PostDto;
import com.remzi.springblogapi.payload.PostResponse;
import com.remzi.springblogapi.service.PostService;
import com.remzi.springblogapi.utils.AppConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "CRUD Rest APIs for Post resources")
@RestController // Bu @Controller , @Controller da @Component anotayonundan miras alır. Yani
                // aslında bu class içinde bir instance olusur.
@RequestMapping()
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // GET : Veri görüntülemek istediğimiz zaman kullanıyoruz.
    // POST : Veri kaydetmek istediğimiz zaman kullanıyoruz.
    // PUT : Veri güncellemek istediğimiz zaman kullanıyoruz.
    // PATCH : Verinin bir bölümünü güncellemek istediğimiz zaman kullanıyoruz. Örn:
    // Parola güncellemek gibi.
    // DELETE : Veri silmek istediğimiz zaman kullanıyoruz.

    @ApiOperation(value = "Create Post REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/v1/posts/create")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All Posts REST API")
    @GetMapping("/api/v1/posts")
    public PostResponse getAllPost(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    @ApiOperation(value = "Get Post By Id REST API")
    @GetMapping(value = "/api/posts/{id}")
    public ResponseEntity<PostDto> getPostByIdV1(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @GetMapping(value = "/api/posts/headr") /// requeste header almak istersek...
    public ResponseEntity<PostDto> getPostByHeader(@RequestHeader(name = "My-Header") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    /// Çoklu post kaydetme
    @PostMapping("/api/v1/posts/create/all")
    public ResponseEntity<List<PostDto>> createPostAll(@Valid @RequestBody List<PostDto> postDto) {
        postDto.forEach(post -> post.setId(null));
        return new ResponseEntity<>(postService.createPostAll(postDto), HttpStatus.CREATED);
    }

    // @GetMapping(value = "/api/posts/{id}", produces =
    // "application/vnd.javaguides.v2+json")
    // public ResponseEntity<PostDToV2> getPostByIdV2(@PathVariable(name = "id")
    // long id) {
    // PostDto postDto = postService.getPostById(id);

    // PostDToV2 postDToV2 = new PostDToV2();
    // postDToV2.setId(postDto.getId());
    // postDToV2.setContent(postDto.getContent());
    // postDToV2.setDescription(postDto.getDescription());
    // postDToV2.setTitle(postDto.getTitle());

    // List<String> tags = new ArrayList<>();
    // tags.add("Java");
    // tags.add("Spring Boot");
    // tags.add("AWS");
    // postDToV2.setTags(tags);
    // return ResponseEntity.ok(postDToV2);
    // }

    @ApiOperation(value = "Update Post By Id REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/api/v1/posts/update/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Post By Id REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/v1/posts/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }

}
