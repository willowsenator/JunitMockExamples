package com.willow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FahrToCelcConverterTest {

    @ParameterizedTest
    @CsvSource({
            "0, 32",
            "37, 98",
            "100, 212"
    })
    void shouldConvertCelsiusToFahrenheit(String celsius, String fahrenheit){
        Assertions.assertThat(FahrToCelcConverter
                .toFahrenheit(Integer.parseInt(celsius)))
                .isEqualTo(Integer.parseInt(fahrenheit));
    }

    @ParameterizedTest
    @CsvSource({
            "32, 0",
            "100, 37",
            "212, 100"
    })
    void shouldConvertFahrenheitToCelsius(String fahrenheit, String celsius){
        Assertions.assertThat(FahrToCelcConverter
                .toCelcius(Integer.parseInt(fahrenheit)))
                .isEqualTo(Integer.parseInt(celsius));
    }
}
