package com.willow.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookingServiceTest{
    private static final String DAY1 = "Monday, 14th of June";
    private static final String DAY2 = "Monday, 14th of June";
    private static final String TIME_SLOT1 = "from 12 to 13 pm";
    private static final String TIME_SLOT2 = "from 10 to 11 am";
    private static final String ID1 = "A1";
    private static final String ID2 = "A2";
    private static final int CAPACITY1 = 20;
    private static final int CAPACITY2 = 10;
    private static final List<Equipment> EQUIPMENT1 = Arrays.asList(
            Equipment.PROJECTOR, Equipment.MICROPHONE, Equipment.WHITEBOARD
    );
    private static final List<Equipment> EQUIPMENT2 = Arrays.asList(
            Equipment.WHITEBOARD, Equipment.MICROPHONE
    );

    private static final String ID_NOT_FOUND = "B3";

    private BookingService bookingService;
    private ClassRoom classRoom1 = mock(ClassRoom.class);
    private ClassRoom classRoom2 = mock(ClassRoom.class);
    private Support support = mock(Support.class);

    @BeforeEach
    void setUp(){

        prepareClassRoomMock(classRoom1, ID1, CAPACITY1, EQUIPMENT1, DAY1, TIME_SLOT1 );
        prepareClassRoomMock(classRoom2, ID2, CAPACITY2, EQUIPMENT2, DAY2, TIME_SLOT2 );


        bookingService = new BookingService(Arrays.asList(
            classRoom1, classRoom2
        ), support);
    }


    @Test
    void listAllClassRoomsShouldReturnAllExistingClassrooms(){
        List<ClassRoom> classRooms = bookingService.getClassRooms();

        assertThat(classRooms).isNotNull();
        assertThat(classRooms.size()).isEqualTo(2);
    }

    @Test
    void listClassRoomsByDayAndTimeSlotShouldReturnClassRoomsFilteredByDayAndTimeSlot(){
        List<ClassRoom> classRooms = bookingService.getClassRooms(DAY1, TIME_SLOT1);

        assertThat(classRooms).isNotNull();
        assertThat(classRooms.size()).isEqualTo(1);
        assertThat(classRooms.get(0).getDay()).isEqualTo(DAY1);
        assertThat(classRooms.get(0).getTimeSlot()).isEqualTo(TIME_SLOT1);
    }

    @Test
    void bookByIdShouldReturnTrueIfOK(){
        boolean isBooked = bookingService.book(ID1);

        assertThat(isBooked).isTrue();
        verify(support).notifyBooking(ID1);
    }

    @Test
    void bookByIdShouldReturnFalseIfNotFound(){
        boolean isBooked = bookingService.book(ID_NOT_FOUND);

        assertThat(isBooked).isFalse();
        verify(support, never()).notifyBooking(ID_NOT_FOUND);
    }

    @Test
    void bookWithRestrictionsShouldReturnTrueIfOk(){
        boolean isBooked = bookingService.book(CAPACITY1, Equipment.PROJECTOR);

        assertThat(isBooked).isTrue();
        verify(support).notifyBooking(CAPACITY1, Equipment.PROJECTOR);
    }

    @Test
    void bookWithRestrictionsShouldReturnFalseIfNotFound(){
        boolean isBooked = bookingService.book(CAPACITY2, Equipment.PROJECTOR);

        assertThat(isBooked).isFalse();
        verify(support, never()).notifyBooking(CAPACITY2, Equipment.PROJECTOR);
    }



    private void prepareClassRoomMock(ClassRoom classRoom, String id, int capacity, List<Equipment> equipments,
                                      String day, String timeSlot) {
        when(classRoom.getId()).thenReturn(id);
        when(classRoom.getCapacity()).thenReturn(capacity);
        when(classRoom.getEquipments()).thenReturn(equipments);
        when(classRoom.getDay()).thenReturn(day);
        when(classRoom.getTimeSlot()).thenReturn(timeSlot);
    }
}
