package ua.university;

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

    }
}
