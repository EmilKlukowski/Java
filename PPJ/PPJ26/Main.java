package PPJ26;

public class Main{
    public static void main(String[] args) {
        Osoba marek = new Osoba("Marek");
        Osoba kamil = new Osoba("Kamil");
        Osoba daniel = new Osoba("Daniel");
        RachunekBankowy rMarka = new RachunekBankowy(marek, 2000.0);
        RachunekBankowy rKamila = new RachunekBankowy(kamil, 1000.0);

        try{
            rMarka.wplata(200);
            rMarka.przelew(rKamila, 500);
            rMarka.showStan();

        }catch(BlednaOperacja e){
            System.out.println("Cos poszlo nie tak: " + e);
        }
        //3===========================================================
        KontoVip vipDaniel = new KontoVip(2, daniel, 3000, -300);
        try{
            vipDaniel.showStan();      //stan :5000
            vipDaniel.przelew(rMarka, 3200);
            vipDaniel.showStan();      //stan :-299

        }catch(BlednaOperacja e){
            System.out.println(e);
        }


    }
}
