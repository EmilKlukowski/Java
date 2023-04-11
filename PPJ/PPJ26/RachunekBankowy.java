package PPJ26;

public class RachunekBankowy {
    private Osoba wlasciciel;
    private double stan;

    public RachunekBankowy(Osoba wlasciciel, double stan) {
        this.wlasciciel = wlasciciel;
        this.stan = stan;
    }

    public void wplata(double wplata) throws BlednaOperacja {
        {
            if (wplata <= 0)
                throw new BlednaOperacja("Kwota wplaty mniejsza niz 0");
        }

        this.stan += wplata;
    }

    public void wyplata(double wyplata) throws BlednaOperacja {
        {
            if (wyplata <= 0)
                throw new BlednaOperacja("Kwota wyplaty mniejsza od 0");
        }

        this.stan -= wyplata;
    }

    public void showStan() {
        System.out.println(this.stan);
    }

    public double getStan() {
        return stan;
    }

    public void przelew(RachunekBankowy rach, double kwotaPrzel) throws BlednaOperacja {
        {
            if (kwotaPrzel < 0)
                throw new BlednaOperacja("Ujemna kwota przelewu");
        }
        {
            if (this.stan > kwotaPrzel) {
                rach.wplata(kwotaPrzel);
                this.wyplata(kwotaPrzel);
            } else {
                throw new BlednaOperacja("Za malo pieniedzy na koncie");
            }
        }
    }


}
