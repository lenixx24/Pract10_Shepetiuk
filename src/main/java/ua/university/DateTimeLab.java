package ua.university;

import java.time.*;

public class DateTimeLab {
    public static Instant toInstant(Event e){
        return e.getStart().atZone(e.getZone()).toInstant();
    }
    public static Duration minutesBetween(Event a, Event b){
        return Duration.between(DateTimeLab.toInstant(a), DateTimeLab.toInstant(b));
    }
    public static LocalDateTime startInZone(Event e, String zone){
        return e.getStart().atZone(ZoneId.of(zone)).toLocalDateTime();
    }
}
