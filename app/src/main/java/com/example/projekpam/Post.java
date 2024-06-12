package com.example.projekpam;

public class Post {
    private String id;
    private String email;
    private String title;
    private String content;

    public Post() {
        // Diperlukan untuk Firebase
    }

    public Post(String id, String title, String content, String email) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
