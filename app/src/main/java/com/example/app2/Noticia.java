package com.example.app2;

import java.util.List;

public class Noticia
{
    private String author;
    private String title;
    private String description;
    private String urlToImage;
    private String url;
    private String publisehAt;

    public Noticia(String author, String title, String description, String urlToImage, String url, String publisehAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
        this.url = url;
        this.publisehAt = publisehAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublisehAt() {
        return publisehAt;
    }

    public void setPublisehAt(String publisehAt) {
        this.publisehAt = publisehAt;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", url='" + url + '\'' +
                ", publisehAt='" + publisehAt + '\'' +
                '}';
    }
}
