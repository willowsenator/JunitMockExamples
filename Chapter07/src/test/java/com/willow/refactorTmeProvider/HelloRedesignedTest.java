package com.willow.refactorTmeProvider;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HelloRedesignedTest {
    private HelloRedesigned hello;
    private TimeProvider timeProvider;

    @BeforeEach
    void setUp(){
        timeProvider = mock(TimeProvider.class);
        hello = new HelloRedesigned(timeProvider);
    }


    @Test
    void shouldSayGoodMorningInTheMorning(){
        when(timeProvider.isMorning()).thenReturn(true);
        assertEquals("Good Morning!", hello.sayHello());
    }

    @Test
    void shouldSayGoodAfternoonInTheAfternoon(){
        when(timeProvider.isMorning()).thenReturn(false);
        assertEquals("Good Afternoon!", hello.sayHello());
    }

}