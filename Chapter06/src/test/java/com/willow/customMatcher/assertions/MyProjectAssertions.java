package com.willow.customMatcher.assertions;

import com.willow.customMatcher.Book;
import com.willow.customMatcher.Movie;
import org.assertj.core.api.Assertions;

public class MyProjectAssertions extends Assertions {
    public static BookAssert assertThat(Book actual){
        return new BookAssert(actual);
    }

    public static MovieAssert assertThat(Movie actual){
        return new MovieAssert(actual);
    }
}
