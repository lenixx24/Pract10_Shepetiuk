package ua.university;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaRefactorLab {
    public static void sortAnonymous(List<String> strings){
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
    public static void sortLambda(List<String> strings){

        strings.sort((a, b) -> a.compareTo(b));
    }
    public static void sortMethodRef(List<String> strings){
        strings.sort(String::compareTo);
    }

    static void main() {
        List<String> strings = new ArrayList<>();
        strings.add("B"); strings.add("c"); strings.add("A"); strings.add("anonymous"); strings.add("y");
        System.out.println(strings);
        sortAnonymous(strings);
        System.out.println("Anonymous: "+strings);
        strings.add("lambda");
        sortLambda(strings);
        System.out.println("Lambda: "+strings);
        strings.add("methodref");
        sortMethodRef(strings);
        System.out.println("Method ref: "+strings);
    }
}
