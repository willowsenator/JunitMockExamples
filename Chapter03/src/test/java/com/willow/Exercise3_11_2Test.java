package com.willow;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Exercise3_11_2Test {
    @Test
    void learnAssertJ(){
        var var = "2.5";
        assertThat(var).isEqualTo(var);
    }
}
