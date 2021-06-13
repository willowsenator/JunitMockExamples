package com.willow.booking;

public interface Support {
    void notifyBooking(String id);
    void notifyBooking(int day, Equipment equipment);
}
