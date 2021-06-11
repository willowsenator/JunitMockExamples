package com.willow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

public class Exercise_3_11_3Test {

    private static Map<String, String> reversedMap = new HashMap<>();

    static{
        reversedMap.put("", "");
        reversedMap.put("a", "a");
        reversedMap.put("ab", "ba");
        reversedMap.put("ba", "ab");
        reversedMap.put("baa", "aab");
    }


    @Test
    void reverseShouldThrowExceptionForNull(){
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(()->{Exercise_3_11_3.reverse(null);});
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "ab", "ba", "baa"})
    void reserveShouldReturnReversedStringForCorrectString(String string){
        String reversedString = Exercise_3_11_3.reverse(string);
        Assertions.assertThat(reversedString).isNotNull();
        Assertions.assertThat(reversedString).isEqualTo(reversedMap.get(string));
    }
}
