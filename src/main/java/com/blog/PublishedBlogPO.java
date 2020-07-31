package com.blog;


import java.time.Instant;

public class PublishedBlogPO {
    private String publishedTitle;
    private String publishedBody;
    private Instant publishedAt;

    protected PublishedBlogPO() {
    }

    protected PublishedBlogPO(String publishedTitle, String publishedBody, Instant publishedAt) {
        this.publishedTitle = publishedTitle;
        this.publishedBody = publishedBody;
        this.publishedAt = publishedAt;
    }

}
