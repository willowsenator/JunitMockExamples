package com.willow.race;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {
    private RaceResultsService raceResults = new RaceResultsService();
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Message message = mock(Message.class);

    @Test
    void notSubscribedClientShouldNotReceiveMessage(){
        raceResults.send(message);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    void subscribedClientShouldReceiveMessage(){
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

        verify(clientA).receive(message);
    }

    @Test
    void messageShouldBeSentToAllSubscribedClients(){
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    void shouldSendOnlyOneMessageToMultiSubscriber(){
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

        verify(clientA).receive(message);
    }

    @Test
    void unsubscribedClientShouldNotReceiveMessages(){
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);

        raceResults.send(message);

        verify(clientA, never()).receive(message);
    }
}
