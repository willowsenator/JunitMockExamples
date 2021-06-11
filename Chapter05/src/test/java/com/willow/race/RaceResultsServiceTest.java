package com.willow.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    private static final Set<Category> CATEGORIES_1 = Set.of(Category.F1, Category.HORSE);
    private static final Set<Category> CATEGORIES_2 = Set.of(Category.BOAT);

    private RaceResultsService raceResults = new RaceResultsService();
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Message message1 = mock(Message.class);
    private Message message2 = mock(Message.class);

    @BeforeEach
    void setUp(){
        when(message1.getCategory()).thenReturn(Category.F1);
        when(message2.getCategory()).thenReturn(Category.HORSE);
    }

    @Test
    void notSubscribedClientShouldNotReceiveMessage(){
        raceResults.send(message1);

        verify(clientA, never()).receive(message1);
        verify(clientB, never()).receive(message1);
    }

    @Test
    void subscribedClientShouldReceiveMessagesFromDifferentCategories(){
        raceResults.addSubscriber(clientA, CATEGORIES_1);
        raceResults.send(message1);
        raceResults.send(message2);

        verify(clientA).receive(message1);
        verify(clientA).receive(message2);
    }

    @Test
    void messagesShouldBeSentToAllSubscribedClientsOfCategory(){
        raceResults.addSubscriber(clientA, CATEGORIES_1);
        raceResults.addSubscriber(clientB, CATEGORIES_2);

        raceResults.send(message1);
        raceResults.send(message2);

        verify(clientA).receive(message1);
        verify(clientB, never()).receive(message2);
    }

    @Test
    void shouldSendOnlyOneMessageForCategoryToMultiSubscriber(){
        raceResults.addSubscriber(clientA, CATEGORIES_1);
        raceResults.addSubscriber(clientA, CATEGORIES_1);
        raceResults.send(message1);
        raceResults.send(message2);

        verify(clientA).receive(message1);
        verify(clientA).receive(message2);
    }

    @Test
    void unsubscribedClientShouldNotReceiveMessages(){
        raceResults.addSubscriber(clientA, CATEGORIES_1);
        raceResults.removeSubscriber(clientA);

        raceResults.send(message1);
        raceResults.send(message2);

        verify(clientA, never()).receive(message1);
        verify(clientA, never()).receive(message2);
    }

    @Test
    void removeSubscriberShouldReturnFalseWhenNotSubscribed(){
       assertThat(raceResults.removeSubscriber(clientA)).isNull();
    }

}
