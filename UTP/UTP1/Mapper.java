/**
 *
 *  @author Klukowski Emil S27944
 *
 */

package zad1;


import java.util.List;

public interface Mapper<E, T> { // Uwaga: interfejs musi być sparametrtyzowany
    T map(E element);
}  
