package com.willow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorTest {
    PasswordValidator passwordValidator = new PasswordValidator();

    @ParameterizedTest
    @ValueSource(strings = {"23_ab", "c23_b", "cad23_bbbbb"})
    void validateShouldReturnTrueWhenIsCorrect(String password){
        assertThat(passwordValidator.validate(password)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ca_b", "cad23-bbbbb"})
    void validateShouldReturnFalseWhenIsNotCorrect(String password){
        assertThat(passwordValidator.validate(password)).isFalse();
    }
}
