package com.willow.customMatcher.assertions;

import com.willow.customMatcher.Movie;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovieAssert extends AbstractAssert<MovieAssert, Movie> {
    public MovieAssert(Movie actual){
        super(actual, MovieAssert.class);
    }

    public MovieAssert hasWonOscar(){
        assertThat(actual.isHasWonOscar()).isTrue();
        return this;
    }
}
