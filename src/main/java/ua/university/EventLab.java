package ua.university;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class EventLab {
    public static List<Event> pick(List<Event> events, Predicate<Event> rule){
        List<Event> res = new ArrayList<>();
        for(Event e: events){
           if(rule.test(e)) res.add(e);
        }
            return res;
    }
    public static List<String> labels(List<Event> events, Function<Event, String> func){
        List<String> res = new ArrayList<>();
        for(Event e: events){
            res.add(func.apply(e));
        }
        return  res;
    }
    public static void notifyAll(List<Event> events, Consumer<Event> cons){
        for(Event e: events){
            cons.accept(e);
        }
    }
    public static Event create(Supplier<Event> sup){
        return sup.get();
    }
    public static void findConflicts(List<Event> events){
            for(int i=0; i<events.size()-1; i++){
                Event e = events.get(i);
                for(int j=i+1; j<events.size(); j++){
                    Event e2 = events.get(j);
                    if(isConflict(e, e2)){
                        System.out.println(e.label()+" are in conflict with "+e2.label());
                    }
                }
            }
    }

    private static boolean isConflict(Event e1, Event e2) {
        Instant start1 = e1.getStart().atZone(e1.getZone()).toInstant();
        Instant end1 = e1.end().atZone(e1.getZone()).toInstant();

        Instant start2= e2.getStart().atZone(e2.getZone()).toInstant();
        Instant end2 = e2.end().atZone(e2.getZone()).toInstant();
        return start1.isBefore(end2)&&end1.isAfter(start2);
    }
}
