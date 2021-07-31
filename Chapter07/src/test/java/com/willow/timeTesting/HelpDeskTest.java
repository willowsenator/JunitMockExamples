package com.willow.timeTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Calendar;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HelpDeskTest {
    HelpDesk helpDesk;
    TimeProvider timeProvider;
    Issue issue;

    @BeforeEach
    void setUp(){
        timeProvider = mock(TimeProvider.class);
        issue = mock(Issue.class);
        helpDesk = new HelpDesk(timeProvider);
    }


    static Stream<Arguments> weekendDays(){
        return Stream.of(Arguments.of(Calendar.SATURDAY),
                         Arguments.of(Calendar.SUNDAY));
    }

    static Stream<Arguments> daysOfWeek(){

        return Stream.of(Arguments.of(Calendar.MONDAY),
                Arguments.of(Calendar.TUESDAY),
                Arguments.of(Calendar.WEDNESDAY),
                Arguments.of(Calendar.THURSDAY),
                Arguments.of(Calendar.FRIDAY));

    }

   @ParameterizedTest
   @MethodSource("weekendDays")
    void shouldReturnFalseWhenWeekend(int weekendDays){
        when(timeProvider.getTime()).thenReturn(getCalendar(weekendDays, HelpDesk.EOB_HOUR));

        assertThat(helpDesk.willHandleIssue(issue)).isFalse();
   }


   @ParameterizedTest
   @MethodSource("daysOfWeek")
   void shouldReturnTrueWhenNotWeekendAndHourEqualTo17(int dayOfWeek){
       when(timeProvider.getTime()).thenReturn(getCalendar(dayOfWeek, HelpDesk.EOB_HOUR));

       assertThat(helpDesk.willHandleIssue(issue)).isTrue();

   }


    @Test
    void shouldReturnFalseWhenDayOfWeekFridayAndHourGreaterThant17(){
        when(timeProvider.getTime()).thenReturn(getCalendar(Calendar.FRIDAY, HelpDesk.EOB_HOUR + 1));

        assertThat(helpDesk.willHandleIssue(issue)).isFalse();

    }


   private Calendar getCalendar(int dayOfWeek, int hourOfDay){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        return cal;
   }



}