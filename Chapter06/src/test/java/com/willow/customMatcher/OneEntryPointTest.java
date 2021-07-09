package com.willow.customMatcher;

import org.junit.jupiter.api.Test;

import static com.willow.customMatcher.MyProjectAssertions.assertThat;

public class OneEntryPointTest {
    @Test
    void shouldUseAssert(){
        assertThat(true).isTrue();
        assertThat(new Book("title")).hasTitle("title");
        assertThat(new Movie(true)).hasWonOscar();
    }
}
