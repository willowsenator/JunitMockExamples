package com.willow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingSystem {
    private static final String[] bookingHours = {"4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm"};
    private static Map<String, String> bookedHours = new HashMap<>();

    public List<String> getBookingHours() {
        return Arrays.asList(bookingHours);
    }

    public boolean book(String hourToBook, String resource) {
        if(Arrays.stream(bookingHours).filter(bookingHour -> bookingHour.equals(hourToBook)).count() == 1){
            if(!bookedHours.containsKey(hourToBook)) {
                bookedHours.put(hourToBook, resource);
                return true;
            }
        }
        throw new IllegalArgumentException();
    }
}
