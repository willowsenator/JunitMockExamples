package com.willow.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    List<ClassRoom> clasrooms = new ArrayList<>();

    public BookingService(List<ClassRoom> clasrooms){
        this.clasrooms.addAll(clasrooms);
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
        return clasrooms.stream().filter(classRoom -> classRoom.getId().equals(id)).count() == 1;
    }

    public boolean book(int capacity, Equipment equipment) {
        return clasrooms.stream().filter(classRoom -> classRoom.getCapacity() == capacity)
                .filter(classRoom -> classRoom.getEquipments().stream().filter(
                        equipmentToCheck -> equipmentToCheck.equals(equipment)).count() == 1).count() == 1;
    }
}
