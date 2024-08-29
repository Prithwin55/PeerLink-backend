package com.peerlink_backend.peerlink_backend.api.controller.post;

import com.peerlink_backend.peerlink_backend.api.dto.post.PostDto;
import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import com.peerlink_backend.peerlink_backend.data.entity.post.Post;
import com.peerlink_backend.peerlink_backend.data.service.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/peerlink/post")
public class PostController {

    PostService postService;
    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestHeader("Authorization")String jwt,@RequestBody PostDto postDto){
        return new ResponseEntity(postService.createPost(jwt,postDto), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PostDto> findPostById(@PathVariable long id){
        return ResponseEntity.ok(postService.findPostById(id));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<PostDto>> findPostByUserId(@RequestBody UserDto userDto){
        return ResponseEntity.ok(postService.findPostByUserId(userDto));
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePost(@RequestHeader("Authorization")String jwt,@PathVariable long postId){
        return ResponseEntity.ok(postService.deletePost(jwt,postId));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> findAllPost(){
       return ResponseEntity.ok(postService.findAllPost());
    }

    @PutMapping("/like/{postId}")
    public ResponseEntity<PostDto> likePost(@RequestHeader("Authorization")String jwt,@PathVariable long postId){
        return ResponseEntity.ok(postService.likePost(jwt, postId));
    }

    @PutMapping("/save/{postId}")
    public ResponseEntity<UserDtoDetails> savePost(@RequestHeader("Authorization")String jwt, @PathVariable long postId){
        return  ResponseEntity.ok(postService.savePost(jwt, postId));
    }
}
