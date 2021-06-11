package com.willow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegexTest {
    private Regex regex = new Regex();

    @ParameterizedTest
    @CsvSource(value = {
                        "cdefg 345 12bb23 ; 345",
                        "cdefg 345 12bbb33 678tt; 345, 678"
    }, delimiter = ';')
    void getNumberListShouldReturnNumberListWhenIsOk(String input, String output){
        assertThat(regex.getNumberList(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(strings = "abc 12")
    void getNumberListShouldReturnEmptyWhenIsNotOK(String input){
        assertThat(regex.getNumberList(input)).isEqualTo("");
    }

}
