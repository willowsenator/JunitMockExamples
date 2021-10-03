package com.willow.testingLegacyCode;

public class EmailServer {
    public static void sendEmail(Email email){
        System.out.println("--------Sending Email-------------");
        System.out.println("Address: " + email.getAddress());
        System.out.println("Title: " + email.getTitle());
        System.out.println("Body: " + email.getBody());

    }
}
