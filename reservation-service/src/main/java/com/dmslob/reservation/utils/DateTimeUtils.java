package com.dmslob.reservation.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeUtils {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate createDateFromDateString(String dateString) {
        LocalDate date;
        if (StringUtils.isNotBlank(dateString)) {
            date = LocalDate.parse(dateString, DATE_TIME_FORMATTER);
        } else {
            date = LocalDate.now();
        }
        return date;
    }

    public String createDateStringFromDate(LocalDate date) {
        if (null == date) {
            return DATE_TIME_FORMATTER.format(LocalDate.now());
        }
        return DATE_TIME_FORMATTER.format(date);
    }
}
