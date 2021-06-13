package com.willow.booking;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    List<ClassRoom> clasrooms = new ArrayList<>();

    public BookingService(List<ClassRoom> clasrooms){
        this.clasrooms.addAll(clasrooms);
    }

    public List<ClassRoom> getAllClassRooms() {
        return clasrooms;
    }
}
