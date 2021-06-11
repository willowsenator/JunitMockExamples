package com.willow;

public class PasswordValidator {
    private static final String patternRegex = "\\w{5,}";
    public boolean validate(String password) {
        return password.matches(patternRegex);
    }
}
