package com.gfieast.akademia.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {

    private static final ZoneId DATE_TIME_ZONE_ID = ZoneId.systemDefault();

    private DateTimeUtil() {
    }

    public static LocalDateTime toLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, DATE_TIME_ZONE_ID);
    }
}
