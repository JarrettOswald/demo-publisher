package ru.korepanov.demopostrest.controllers;


import io.swagger.api.ServiceApi;
import io.swagger.model.Post;
import org.jooq.generated.tables.records.PostsRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.korepanov.demopostrest.mapper.PostMapperImpl;
import ru.korepanov.demopostrest.repositories.UserRepository;

import java.util.Objects;

@RestController
public class PostsController implements ServiceApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostsController.class);
    private static final PostMapperImpl mapper = new PostMapperImpl();

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Post> getPostById(Integer postId) {
        PostsRecord postsRecord = userRepository.selectPostById(postId);
        if (Objects.isNull(postsRecord)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Post post = mapper.postsRecordToPost(postsRecord);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> newPost(Post post) {
        userRepository.insetPost(post);
        return new ResponseEntity<>("Add new post", HttpStatus.OK);
    }
}
