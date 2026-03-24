package ua.university;

import java.time.LocalDateTime;
import java.time.ZoneId;

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
        System.out.println(ev3);
    }
}
