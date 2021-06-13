package com.willow.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    List<ClassRoom> clasrooms = new ArrayList<>();
    Support support;

    public BookingService(List<ClassRoom> clasrooms, Support support){
        this.clasrooms.addAll(clasrooms);
        this.support = support;
    }

    public List<ClassRoom> getClassRooms() {
        return clasrooms;
    }

    public List<ClassRoom> getClassRooms(String day, String timeSlot) {
        return clasrooms.stream().filter(
                classRoom -> classRoom.getDay().equals(day) && classRoom.getTimeSlot().equals(timeSlot)
        ).collect(Collectors.toList());
    }

    public boolean book(String id) {
        boolean isBooked = clasrooms.stream().filter(classRoom -> classRoom.getId().equals(id)).count() == 1;
        if(isBooked){
            support.notifyBooking(id);
        }
        return isBooked;
    }

    public boolean book(int capacity, Equipment equipment) {
        boolean isBooked = clasrooms.stream().filter(classRoom -> classRoom.getCapacity() == capacity)
                .filter(classRoom -> classRoom.getEquipments().stream().filter(
                        equipmentToCheck -> equipmentToCheck.equals(equipment)).count() == 1).count() == 1;

        if(isBooked){
            support.notifyBooking(capacity, equipment);
        }

        return isBooked;
    }
}
