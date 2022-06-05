package ru.korepanov.demopostrest.repositories;

import io.swagger.model.Post;
import org.jooq.generated.tables.records.PostsRecord;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.korepanov.demopostrest.controllers.PostsController;


@SpringBootTest
class UserRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(PostsController.class);
    @Autowired
    private UserRepository userRepository;

    @Test
    void selectPostByIdTest() {
        PostsRecord postsRecord = userRepository.selectPostById(1);
        String actualValue = postsRecord.getTitle();
        logger.info("Actual value:{}", actualValue);
        Assertions.assertEquals("Вечера в России", actualValue);
    }

}