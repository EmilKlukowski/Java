package GUI3;

import java.util.Arrays;
import java.util.Comparator;

public class Main {


    //4=================
    private static final Comparator<Osoba> WG_NAZWISKA = (o1, o2) -> {
        if (o1.getNazwisko().compareTo(o2.getNazwisko()) != 0) {
            return o1.getNazwisko().compareTo(o2.getNazwisko());
        }
        if (o1.getImie().compareTo(o2.getImie()) != 0) {
            return o1.getImie().compareTo(o2.getImie());
        }

        return Long.compare(o1.getPesel(), o2.getPesel());
    };

    private static final Comparator<Osoba> WG_NAZWISKA2 = Comparator
            .comparing(Osoba::getNazwisko)
            .thenComparing(Osoba::getImie)
            .thenComparing(Osoba::getPesel);

    private static final Comparator<Szachista> WG_RANKINGU = (s1, s2) -> {
        if (s1.getRanking() != s2.getRanking()) {
            return s2.getRanking() - s1.getRanking();
        }else{
            return WG_NAZWISKA.compare(s1, s2);
        }
    };

    private static final Comparator<Szachista> WG_RANKINGU2 = Comparator
            .comparing(Szachista::getRanking)
            .reversed()
            .thenComparing(WG_NAZWISKA);


    public static void main(String[] args) {

//        for (DzienTygodnia day: DzienTygodnia.values()) {
//            System.out.println(day + "; " + (day.czyWeekend() ? "weekend" : "roboczy") +
//                    "; następny: " + day.nastepny() + "; " + day.ileDniPo(DzienTygodnia.CZ)
//                    + " dni po czwartku");
//            System.out.println(day.ordinal());
//        }


        Szachista[] szachisci = {
                new Szachista("Jan", "Kowalski", 1, 1200),
                new Szachista("Anna", "Nowak", 2, 1400),
                new Szachista("Tomasz", "Wiśniewski", 3, 1380),
                new Szachista("Barbara", "Marciniak", 4, 1400)
        };

        Osoba[] osoby = {
                szachisci[0],
                szachisci[1],
                szachisci[2],
                szachisci[3],
                new Osoba("Jan", "Kowalski", 5),
                new Osoba("Marta", "Wójcik", 6)
        };

        new WyswietlaczTablic<Osoba>().wyswietl(osoby, WG_NAZWISKA2);
        new WyswietlaczTablic<Osoba>().wyswietl(szachisci, WG_NAZWISKA2);
        new WyswietlaczTablic<Szachista>().wyswietl(szachisci, WG_RANKINGU2);


    }
}
