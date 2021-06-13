package com.willow.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingServiceTest{
    private BookingService bookingService;
    private ClassRoom classRoom1 = mock(ClassRoom.class);
    private ClassRoom classRoom2 = mock(ClassRoom.class);

    @BeforeEach
    void setUp(){

        prepareClassRoomMock(classRoom1, "A1", 20, Arrays.asList(
                Equipment.PROJECTOR, Equipment.MICROPHONE, Equipment.WHITEBOARD
        ));
        prepareClassRoomMock(classRoom2, "A2", 10, Arrays.asList(
               Equipment.MICROPHONE, Equipment.WHITEBOARD
        ));


        bookingService = new BookingService(Arrays.asList(
            classRoom1, classRoom2
        ));
    }


    @Test
    void listClassroomsShouldReturnAllExistingClassrooms(){
        List<ClassRoom> classRooms = bookingService.getAllClassRooms();

        assertThat(classRooms).isNotNull();
        assertThat(classRooms.size()).isEqualTo(2);
    }

    private void prepareClassRoomMock(ClassRoom classRoom, String id, int capacity, List<Equipment> equipments) {
        when(classRoom.getId()).thenReturn(id);
        when(classRoom.getCapacity()).thenReturn(capacity);
        when(classRoom.getEquipments()).thenReturn(equipments);
    }
}
