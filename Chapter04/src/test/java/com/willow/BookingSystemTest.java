package com.willow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BookingSystemTest {
    private BookingSystem bookingSystem = new BookingSystem();
    private String[] bookingHours = {"4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm"};


    @Test
    void getBookedHoursShouldReturnAllowedBookedHours(){
        assertThat(bookingSystem.getBookingHours()).isNotNull();
        assertThat(bookingSystem.getBookingHours()).containsSequence(bookingHours);
    }

    @ParameterizedTest
    @CsvSource({
            "4:00 pm, restaurant",
            "5:00 pm, classroom"
    })
    void bookShouldReturnTrueWhenBookOK(String hourToBook, String resource){
        assertThat(bookingSystem.book(hourToBook, resource));
    }

    @ParameterizedTest
    @CsvSource({
            "4:00 pm, restaurant",
            "5:00 pm, classroom"
    })
    void bookShouldThrownExceptionWhenBookSameHour(String hourToBook, String resource){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> bookingSystem.book(hourToBook, resource)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "9:00 pm, restaurant",
            "8:00 pm, classroom"
    })
    void bookShouldThrownExceptionWhenBookIsInWrongBookingHour(String hourToBook, String resource){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> bookingSystem.book(hourToBook, resource)
        );
    }
}
