package com.willow.testingLegacyCode;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class MailClientTest {
    @Test
    public void testMailClient() {
        Email email = mock(Email.class);
        when(email.getAddress()).thenReturn("ADDRESS");
        when(email.getBody()).thenReturn("BODY");
        when(email.getTitle()).thenReturn("TITLE");

        MailClient client = spy(new MailClient());

        doReturn(email).when(client).createEmail(anyString(), anyString(), anyString());

        client.sendEmail("", "", "");

        verify(client, times(1)).createEmail("", "", "");
        verify(client, times(1)).sendEmail("", "", "");

    }
}