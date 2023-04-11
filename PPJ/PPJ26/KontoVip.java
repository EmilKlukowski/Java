package PPJ26;

public class KontoVip extends Konto{
    double limitDebetu;

    public KontoVip(double oprocentowanie, Osoba wlasciciel, double stan, double limitDebetu) {
        super(oprocentowanie, wlasciciel, stan);
        this.limitDebetu = limitDebetu;
    }

    public void przelew(RachunekBankowy rach, double kwotaPrzel) throws BlednaOperacja {
        if((getStan()-kwotaPrzel)>this.limitDebetu){
            rach.wplata(kwotaPrzel);
            wyplata(kwotaPrzel);
        } else
            throw new BlednaOperacja("Za malo pieniedzy na koncie");

    }



}
