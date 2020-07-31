package com.blog;

import java.time.Instant;

public class BlogPO {

    private String id;
    private String title;
    private String body;
    private String authorId;
    private String status;
    private Instant createdAt;
    private Instant savedAt;
    private PublishedBlogPO published;

    public BlogPO() {
    }

    public BlogPO(String id, String title, String body, String authorId, String status,
                  Instant createdAt, Instant savedAt, PublishedBlogPO published) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorId = authorId;
        this.status = status;
        this.createdAt = createdAt;
        this.savedAt = savedAt;
        this.published = published;
    }

    public String getId() {
        return id;
    }

    public PublishedBlogPO getPublished() {
        return published;
    }
}
