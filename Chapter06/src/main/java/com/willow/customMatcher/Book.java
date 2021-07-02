package com.willow.customMatcher;

public class Book {
    private final String title;
    private String language;

    public Book(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language){
        this.language = language;
    }
}
