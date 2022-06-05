package ru.korepanov.demopostrest.mapper;

import io.swagger.model.Post;
import org.jooq.generated.tables.records.PostsRecord;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {

    Post postsRecordToPost(PostsRecord postsRecord);

    PostsRecord postToPostPostsRecord(Post post);
}
