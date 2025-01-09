package com.group.libraryapp.dto.response;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayOfTHeWeekResponse {
    private String date;
    private String dayOfWeek;

    public DayOfTHeWeekResponse(String date) {
        this.date = date;
        LocalDate localDate = LocalDate.parse(date);
        this.dayOfWeek = localDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US);
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
