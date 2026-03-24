package ua.university;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ZoneId kyiv = ZoneId.of("Europe/Kyiv");
        Event ev1 = new Event("Birthday",
                LocalDateTime.of(2026, 9, 24, 12, 0),
                180, kyiv, "General" );
        Event ev2 = new Event("Good day",
                LocalDateTime.of(2026, 3, 25, 15, 0),
                180, kyiv, "General" );
        Event ev3 = new Event("Easter",
                LocalDateTime.of(2026, 4, 7, 10, 0),
                240, kyiv, "General" );
        System.out.println("End: "+ev1.end());
        System.out.println("Label: "+ev2.label());
        List<Event> events = new ArrayList<>();
        events.add(ev1);   events.add(ev2);  events.add(ev3);
        Predicate<Event> morningEv = event -> event.getStart().getHour() < 12;
        Predicate<Event> isGeneral = event -> "General".equals(event.getTrack());
        Predicate<Event> isLong = event -> event.getDurationMinutes() > 45;
        Predicate<Event> morningLongEvents = morningEv.and(isLong);
        Predicate<Event> shortOrGeneral = isGeneral.or(isLong.negate());
       System.out.println( "Morning events: "+EventLab.pick(events, morningEv));
        System.out.println( "Morning long events: "+EventLab.pick(events, morningLongEvents));
        System.out.println( "Short or general: "+EventLab.pick(events, shortOrGeneral));
        System.out.println( "Labels: "+EventLab.labels(events, Event::label));
        System.out.println( "Created: "+EventLab.create(()-> new Event("Standart",
                LocalDateTime.of(2026, 1, 1, 1, 1),
                        120, kyiv, "General"  )));
        EventLab.notifyAll(events, e -> System.out.println(e.label()+" is notified"));
    }
}
