package com.willow.StateTesting;


import com.willow.stateTesting.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringUtilsTest {
    StringUtils stringUtils = new StringUtils();

    @ParameterizedTest
    @CsvSource({"algo, ogla", "reversed, desrever", " ' ', ' '", "'', ''"})
    void shouldReverseStringWhenIsOk(String original, String reversed){
        assertThat(stringUtils.reverse(original)).isEqualTo(reversed);
    }

    @Test
    void shouldThrownNullExceptionWhenIsNull(){
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(
                ()-> stringUtils.reverse(ArgumentMatchers.isNull())
        );
    }
}