package com.blog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class BlogMapperTest extends MapperTest {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    void insert() {
        BlogPO newBlog = insertBlog();

        Optional<BlogPO> result = blogMapper.findById(newBlog.getId());

        Assertions.assertThat(result).hasValueSatisfying(b -> {
            assertThat(b).isEqualToIgnoringGivenFields(newBlog, "published");
            assertThat(b.getPublished()).isEqualToComparingFieldByField(newBlog.getPublished());
        });
    }

    @Test
    void update() {
        BlogPO newBlog = insertBlog();

        BlogPO updatedBlog = new BlogPO(
                newBlog.getId(),
                "Updated Blog",
                "Updated Something...",
                UUID.randomUUID().toString(),
                "Draft",
                Instant.now(),
                Instant.now(),
                new PublishedBlogPO(
                        "Updated Published Blog",
                        "Updated Published Something...",
                        Instant.now()
                )
        );

        blogMapper.update(updatedBlog);

        Optional<BlogPO> result = blogMapper.findById(newBlog.getId());

        Assertions.assertThat(result).hasValueSatisfying(b -> {
            assertThat(b).isEqualToIgnoringGivenFields(updatedBlog, "published");
            assertThat(b.getPublished()).isEqualToComparingFieldByField(updatedBlog.getPublished());
        });
    }

    @Test
    void existsById() {
        BlogPO newBlog = insertBlog();

        boolean result = blogMapper.existsById(newBlog.getId());

        assertThat(result).isTrue();
    }

    @Test
    void deleteById() {
        BlogPO newBlog = insertBlog();

        blogMapper.deleteById(newBlog.getId());

        Optional<BlogPO> result = blogMapper.findById(newBlog.getId());

        Assertions.assertThat(result).isEmpty();
    }



    private BlogPO insertBlog() {
        BlogPO newBlog = new BlogPO(
                UUID.randomUUID().toString(),
                "Blog",
                "Something...",
                UUID.randomUUID().toString(),
                "Published",
                Instant.now(),
                Instant.now(),
                new PublishedBlogPO(
                        "Published Blog",
                        "Published Something...",
                        Instant.now()
                )
        );

        blogMapper.insert(newBlog);
        return newBlog;
    }

}
