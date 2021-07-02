package com.willow.customMatcher;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static com.willow.customMatcher.assertions.BookAssert.assertThat;

public class BookConditionTest {
    private static final String ENGLISH = "English";

    Condition<Book> writtenInEnglish = new Condition<>(
        book -> book.getLanguage().equals(ENGLISH), "book in English");

    @Test
    void languageCheck(){
        Book book = new Book("title");
        book.setLanguage(ENGLISH);
        assertThat(book).is(writtenInEnglish);
    }
}
