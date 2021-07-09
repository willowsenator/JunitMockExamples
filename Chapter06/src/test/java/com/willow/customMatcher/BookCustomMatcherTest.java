package com.willow.customMatcher;

import org.junit.jupiter.api.Test;

import static com.willow.customMatcher.BookAssert.assertThat;

public class BookCustomMatcherTest {
    private static final String TITLE = "One book";

    @Test
    void constructorShouldSetTitle(){
        Book book = new Book(TITLE);
        assertThat(book).hasTitle(TITLE);
    }
}
