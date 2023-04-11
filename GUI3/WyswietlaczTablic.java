package GUI3;

import java.util.Arrays;
import java.util.Comparator;

public class WyswietlaczTablic<T>{

    public void wyswietl(T[] tab, Comparator<T> porzadek){
        //kopia
        T[] tab2 = Arrays.copyOf(tab, tab.length);
        //sortowanie
        Arrays.sort(tab2, porzadek);
        //wyswietlanie
        System.out.println(Arrays.toString(tab2));
    }

}
