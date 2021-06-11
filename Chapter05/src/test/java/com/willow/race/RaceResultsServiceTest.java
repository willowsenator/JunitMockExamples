package com.willow.race;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RaceResultsServiceTest {
    private RaceResultsService raceResults = new RaceResultsService();
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Message message = mock(Message.class);

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

}
