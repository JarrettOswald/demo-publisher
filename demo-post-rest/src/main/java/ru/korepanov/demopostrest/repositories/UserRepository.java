package ru.korepanov.demopostrest.repositories;


import io.swagger.model.Post;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.tables.Posts;
import org.jooq.generated.tables.records.PostsRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final DSLContext dslContext;

    public PostsRecord selectPostById(int idPost) {
        return dslContext.selectFrom(Posts.POSTS)
                .where(Posts.POSTS.ID.eq(idPost))
                .fetchOne();
    }

    public void insetPost(Post post) {
        dslContext.insertInto(Posts.POSTS
                        , Posts.POSTS.PUBLISH_DATE
                        , Posts.POSTS.USER_ID
                        , Posts.POSTS.TITLE
                        , Posts.POSTS.BODY
                ).values(LocalDateTime.now(), post.getUserId(), post.getTitle(), post.getBody())
                .execute();
    }

    public void deletePostByTitle(String title) {
        dslContext.delete(Posts.POSTS)
                .where(Posts.POSTS.TITLE.eq(title))
                .execute();
    }

}
