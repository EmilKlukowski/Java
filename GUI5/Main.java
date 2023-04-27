package GUI5;

import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Supplier<Integer> dice = () -> (int) (Math.random() * 6) + 1;    //result -> int
        Predicate<Integer> isValidNumber = (x) -> x < 6;    //gets int, result -> true or false
        Function<Integer, Double> divideBy2 = (x) -> (double) (x/2);     //gets int, returns double
        Consumer<Double> print = (x) -> System.out.println("Number: "+ x); //gets int, does something with x

        Stream.generate(dice)
                .filter(isValidNumber)
                .limit(10)
                .map(divideBy2)
                .forEach(print);


//        System.out.println(dice.get());
//        System.out.println(isValidNumber.test(5));
//        System.out.println(isValidNumber.test(8));
//        System.out.println(divideBy2.apply(20));
//        print.accept(divideBy2.apply(20));
    }
}
