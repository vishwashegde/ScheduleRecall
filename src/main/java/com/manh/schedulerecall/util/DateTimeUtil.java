package com.manh.schedulerecall.util;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateTimeUtil {
    public static Timestamp formatStringToTimestamp(String dttmStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Timestamp.valueOf(LocalDateTime.parse(dttmStr, formatter));
    }

    public static String formatDateTimeWithSecond(Timestamp dateTime) {
        if (Objects.isNull(dateTime)) {
            return StringUtils.EMPTY;
        }
        LocalDateTime dateTimeToFormat = dateTime.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeToFormat.format(formatter);
    }
}
