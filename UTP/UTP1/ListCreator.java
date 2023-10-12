/**
 *
 *  @author Klukowski Emil S27944
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class ListCreator<E> { // Uwaga: klasa musi być sparametrtyzowana
    public List<E> list;

    public ListCreator(List<E> list) {
        this.list = list;
    }

    public static <E> ListCreator<E> collectFrom(List<E> list){
        return new ListCreator<E>(list);
    }

    public ListCreator<E> when(Selector<E> selector){
        List<E> toReturnList = new ArrayList<>();

        for (E element:this.list) {
            if(selector.select(element)){
                toReturnList.add(element);
            }
        }

        return new ListCreator<E>(toReturnList);

    }

    public <T> List<T> mapEvery(Mapper<E, T> mapper){
        List<T> mappedList = new ArrayList<>();

        for (E element : this.list) {
            T mappedElement = mapper.map(element);
            mappedList.add(mappedElement);
        }


        return mappedList;
    }

}
