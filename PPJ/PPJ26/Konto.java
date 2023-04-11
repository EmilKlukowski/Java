package PPJ26;

public class Konto extends RachunekBankowy{
    private double oprocentowanie;

    public Konto(double oprocentowanie, Osoba wlasciciel, double stan){
        super(wlasciciel, stan);
        this.oprocentowanie=oprocentowanie;
    }
}
