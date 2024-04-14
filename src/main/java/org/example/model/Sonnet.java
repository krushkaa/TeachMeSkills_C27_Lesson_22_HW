package org.example.model;

import java.util.List;

public class Sonnet {
    private String title;
    private Author author;
    private List<Line> lines;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Sonnet{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", lines=" + lines +
                '}';
    }
}
