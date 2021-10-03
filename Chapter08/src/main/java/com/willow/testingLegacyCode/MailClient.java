package com.willow.testingLegacyCode;

public class MailClient {

    public Email createEmail(String address, String title, String body){
        return new Email(address, title, body);
    }
    public void sendEmail(String address, String title, String body){
        EmailServer.sendEmail(createEmail(address, title, body));
    }
}
