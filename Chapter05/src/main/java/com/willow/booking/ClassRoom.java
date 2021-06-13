package com.willow.booking;

import java.util.List;

public interface ClassRoom {

   String getId();
   int getCapacity();
   List<Equipment> getEquipments();
   String getDay();
   String getTimeSlot();
}
