package Zad1;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<E> { // Uwaga: klasa musi być sparametrtyzowana
    public List<E> list;

    public ListCreator(List<E> list) {
        this.list = list;
    }

    public static <E> ListCreator<E> collectFrom(List<E> list){
        return new ListCreator<E>(list);
    }

    public ListCreator<E> when(Predicate<E> filter){
        List<E> toReturnList = new ArrayList<E>();

        for (E element : this.list) {
            if(filter.test(element)){
                toReturnList.add(element);
            }
        }

        return new ListCreator<>(toReturnList);
    }

    public <T> List<T> mapEvery(Function<E, T> mapper){
        List<T> mappedList = new ArrayList<>();

        for (E element : this.list) {
            T mappedElement = mapper.apply(element);
            mappedList.add(mappedElement);
        }


        return mappedList;
    }

}
