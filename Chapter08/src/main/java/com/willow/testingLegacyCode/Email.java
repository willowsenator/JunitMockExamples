package com.willow.testingLegacyCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Email {
    private String address;
    private String title;
    private String body;
}
