package com.gfieast.akademia.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class DateTimeUtil {

    private static final ZoneId DATE_TIME_ZONE_ID = ZoneId.systemDefault();
    private static final ZoneId DATE_TIME_ZONE_OFFSET = ZoneOffset.systemDefault();

    private DateTimeUtil() {}

    public static Instant toInstant(LocalDateTime localDateTime) {
        return localDateTime.atZone(DATE_TIME_ZONE_OFFSET).toInstant();
    }

    public static LocalDateTime toLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, DATE_TIME_ZONE_ID);
    }
}
