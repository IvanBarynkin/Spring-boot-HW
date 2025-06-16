package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class Article implements Searchable {

    private final String name;
    private final String text;
    private final UUID id;

    public Article(String name, String text, UUID id) {
        this.name = name;
        this.text = text;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return text;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getSearchContentType() {
        return "ARTICLE";
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }

    @Override
    public String searchName() {
        return name;
    }

    public boolean equalsArticle(Article other) {
        return (this.getName().equals(other.getName()));
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }
}
