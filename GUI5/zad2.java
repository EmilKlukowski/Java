package GUI5;

import GUI3.Osoba;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class zad2 {
    public static void main(String[] args) {

        Person[] people = {
                new Person("Tomasz", "Zieliński", 30, "Łódź"),
                new Person("Anna", "Wójcik", 32, "Kraków"),
                new Person("Jan", "Kowalski", 45, "Warszawa"),
                new Person("Piotr", "Nowak", 58, "Wrocław"),
                new Person("Marta", "Nowak", 27, "Warszawa"),
                new Person("Piotr", "Zieliński", 18, "Warszawa"),
                new Person("Jan", "Wójcik", 25, "Warszawa")
        };
        //==
        bySurname(people);
        //==
        System.out.println(avgAge(people));
        //==
        System.out.println("Najmłodsza: " + smallestAge(people));
        //==
        youngestInTheCity(people, "Warszawa");
        youngestInTheCity(people, "Wrocław");
        //==
        Set<String> tmp = differentPeople(people);
        System.out.println(tmp);
    }

    static void bySurname(Person[] people) {
        System.out.println("====By surname, then by name====");
        Stream.of(people)
                .sorted(Comparator.comparing(Person::getSurname)
                        .thenComparing(Person::getName)
                        .reversed())
                .forEach(person -> System.out.println(person.getName() + " " + person.getSurname()));
    }

    static double avgAge(Person[] people) {
        System.out.println("====Average age====");

        return Stream.of(people)
                .mapToInt(Person::getAge)    //return a new stream
                .average()
                .getAsDouble();
    }

    static Person smallestAge(Person[] people) {
        return Stream.of(people)
                .min(Comparator.comparing(Person::getAge))
                .get();
    }

    static void youngestInTheCity(Person[] people, String givenCity){
        System.out.println("====Youngest in the city of " + givenCity+"====");
         Stream.of(people)
                .filter((Person)->Person.getCity()==givenCity)
                .min(Comparator.comparing(Person::getAge))
                .ifPresentOrElse(System.out::println, () ->
                        System.out.println("No people in city " + givenCity));
    }

    static Set<String> differentPeople(Person[] people){
        System.out.println("====No Duplicates====");
        return Stream.of(people)
                .map((person -> person.getName()))
                .collect(Collectors.toSet());
    }

//    static void howManyNames(Person[] people){
//        Map<String, Long> amountOfPeople = Arrays.stream(people)
//                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
//        amountOfPeople.entrySet().stream()
//                .
//
//    }

//    private static void wypiszImionaWgLicznosci(Osoba[] osoby) {
//        Stream.of(osoby)
//                .collect(Collectors.groupingBy(Osoba::getImie))
//                .entrySet()
//                .stream()
//                .sorted(Comparator
//                        .comparing((Map.Entry<String, List<Osoba>> e) -> e.getValue().size())
//                        .reversed()
//                        // opcjonalnie, żeby mieć też porządek wśród grup równolicznych
//                        .thenComparing((Map.Entry<String, List<Osoba>> e) -> e.getKey()))
//                .map(e -> e.getKey() + ": " + e.getValue().size() + " osób")
//                .forEach(System.out::println);
//        // albo:
//        Stream.of(osoby)
//                .collect(Collectors.groupingBy(Osoba::getImie, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .sorted(Comparator
//                        .comparing((Map.Entry<String, Long> e) -> e.getValue())
//                        .reversed()
//                        .thenComparing((Map.Entry<String, Long> e) -> e.getKey()))
//                .map(e -> e.getKey() + ": " + e.getValue() + " osób")
//                .forEach(System.out::println);
//    }
//
//    private static void wypiszMiastaWgGrupWiekowych(Osoba[] osoby) {
//        System.out.println("--- Różne zawody w grupach wiekowych: ---");
//        Stream.of(osoby)
//                .collect(Collectors.groupingBy(Main::grupaWiekowa))
//                .entrySet()
//                .stream()
//                .sorted(Comparator.comparing(Map.Entry::getKey))
//                .forEach(e -> {
//                    String miasta = e.getValue()
//                            .stream()
//                            .map(Osoba::getMiasto)
//                            .distinct()
//                            .collect(Collectors.joining(", "));
//                    System.out.println(e.getKey() + ": " + miasta);
//                });
//    }
}
