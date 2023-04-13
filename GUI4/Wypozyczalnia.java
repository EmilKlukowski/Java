package GUI4;

import java.util.HashMap;
import java.util.Map;

public class Wypozyczalnia {
    private Map<String, Integer> konta = new HashMap<>();

    void zaloz(String stud) throws Exception {
        if(konta.containsKey(stud)){
            throw new Exception("Konto istnieje");
        }

        konta.put(stud, 2);
    }
    void wypozycz(String stud) throws Exception {
        if(!konta.containsKey(stud)){
            throw new Exception("Nie ma takiego konta");
        }

        int srodki = konta.get(stud);

        if(srodki == 0){
            throw new Exception("Za malo srodkow na koncie");
        }

        konta.put(stud, srodki-1);
    }

    void usun(String stud) throws Exception{
        if(!konta.containsKey(stud)){
            throw new Exception("Nie ma takiego konta!");
        }

        konta.remove(stud);
    }

    int stan(String stud) throws Exception {
        if(!konta.containsKey(stud))
            throw new Exception("Nie ma takiego konta!");

        return konta.get(stud);
    }
    
    void wypiszWszystkich(){

        for (String stud : konta.keySet()){
            System.out.println(stud);
        }
    }
}
