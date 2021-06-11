package com.willow.race;

import java.time.LocalDate;

public interface Message {
    Category getCategory();
    LocalDate getDate();
    String getText();
}
