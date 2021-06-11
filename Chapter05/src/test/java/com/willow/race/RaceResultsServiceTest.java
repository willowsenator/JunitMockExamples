package com.willow.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    private static final Set<Category> CATEGORIES_1 = Set.of(Category.F1, Category.HORSE);
    private static final Set<Category> CATEGORIES_2 = Set.of(Category.BOAT);
    private static final LocalDate LOCAL_DATE1 = LocalDate.now();
    private static final LocalDate LOCAL_DATE2 = LocalDate.now();
    private static final String  TEXT1 = "TEXT1";
    private static final String TEXT2 = "TEXT2";


    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Message message1 = mock(Message.class);
    private Message message2 = mock(Message.class);
    private MessageLogger logger = mock(MessageLogger.class);

    private RaceResultsService raceResults = new RaceResultsService(logger);

    @BeforeEach
    void setUp(){
        when(message1.getCategory()).thenReturn(Category.F1);
        when(message1.getDate()).thenReturn(LOCAL_DATE1);
        when(message1.getText()).thenReturn(TEXT1);

        when(message2.getCategory()).thenReturn(Category.HORSE);
        when(message2.getDate()).thenReturn(LOCAL_DATE2);
        when(message2.getText()).thenReturn(TEXT2);
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
    void removeSubscriberShouldReturnNullWhenNotSubscribed(){
       assertThat(raceResults.removeSubscriber(clientA)).isNull();
    }

    @Test
    void removeSubscriberShouldReturnCategoriesWhenSubscribed(){
        raceResults.addSubscriber(clientA, CATEGORIES_1);

        assertThat(raceResults.removeSubscriber(clientA)).isEqualTo(CATEGORIES_1);
    }

    @Test
    void messagesShouldBeLogged(){
        raceResults.addSubscriber(clientA, CATEGORIES_1);
        raceResults.send(message1);
        raceResults.send(message2);

        verify(logger).log(message1);
        verify(logger).log(message2);

        assertThat(message1.getDate()).isEqualTo(LOCAL_DATE1);
        assertThat(message1.getText()).isEqualTo(TEXT1);

        assertThat(message2.getDate()).isEqualTo(LOCAL_DATE2);
        assertThat(message2.getText()).isEqualTo(TEXT2);
    }

}
