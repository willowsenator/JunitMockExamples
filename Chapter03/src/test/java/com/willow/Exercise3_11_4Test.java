package com.willow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

public class Exercise3_11_4Test {
    private Map<String, String> map;
    @BeforeEach
    void setUp(){
        map = new HashMap<>();
    }

    @ParameterizedTest
    @CsvSource(value = {"a, b"})
    void shouldAddElement(String key, String value){
         map.put(key, value);

        Assertions.assertThat(map.get(key)).isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"a, b, c"})
    void shouldReplaceOldElementWhenUseSameKey(String key, String value, String newValue){
        map.put(key, value);
        map.put(key, newValue);

        Assertions.assertThat(map.get(key)).isEqualTo(newValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"a, b"})
    void shouldRemoveElements(String key, String value){
        map.put(key, value);
        map.clear();

        Assertions.assertThat(map.isEmpty()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = "a")
    void shouldAddKeyNull(String value){
        map.put(null, value);

        Assertions.assertThat(map.containsKey(null)).isTrue();
        Assertions.assertThat(map.get(null)).isEqualTo(value);
    }
}
