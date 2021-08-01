package com.willow.customMatcher;

import org.junit.jupiter.api.Test;

import static com.willow.customMatcher.OSAssert.assertThat;

class OperatingSystemTest {

    @Test
    void testUsingMatcher(){
        OperatingSystem min9 = new Mindows9();

        assertThat(min9)
                .is128bit()
                .wasReleaseIn(2019)
                .hasName("Mindows9")
                .hasVersion("9");
    }
}