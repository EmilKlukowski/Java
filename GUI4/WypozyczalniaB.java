package GUI4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WypozyczalniaB {
    private Map<String, List<String>> konta = new HashMap<>();

    void wypozycz(String stud, String film) throws Exception{
        if (!konta.containsKey(stud)){
            konta.put(stud, new ArrayList<>());
        }

        List<String> filmyStudenta = konta.get(stud);

        if(filmyStudenta.contains(film)){
            throw new Exception("Film juz wypoczyczony");
        }else{
            filmyStudenta.add(film);
        }
    }

    void zwroc(String stud, String film) throws Exception {
        if(!konta.containsKey(stud)){
            throw new Exception("Nie ma takiego konta!");
        }


        List<String> filmyStudenta = konta.get(stud);
        if(!filmyStudenta.contains(film)){
            throw new Exception("Film nie byl wypozyczony");
        }

        filmyStudenta.remove(film);
    }

    void wypiszStan(String stud) throws Exception {
        if(!konta.containsKey(stud)){
            throw new Exception("Nie ma takiego konta!");
        }

        List<String> filmyStudenta = konta.get(stud);

        for (String film : filmyStudenta){
            System.out.println(film);
        }
    }

    void zapros(String s1, String s2) throws Exception {
        if(!konta.containsKey(s1)){
            throw new Exception("Nie ma takiego konta zapraszającego!");
        }

        if(konta.containsKey(s2)){
            throw new Exception("Zaproszony ma konto!");
        }

        //pobranie filmów s1
        List<String> filmyS1 = konta.get(s1);
        //przypisanie filmów s1 do s2
        List<String> filmyS2 = filmyS1;
        //stworzenie konta s2

        konta.put(s2, filmyS2);
    }
}
