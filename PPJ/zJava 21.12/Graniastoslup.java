package PPJ21;

public class Graniastoslup extends Trojkat{
    private double wysokoscGraniastoslupa;


    public Graniastoslup(double bokA, double wysokoscTrojkata, double wysokoscGraniastoslupa) {
        super(bokA, wysokoscTrojkata);
        this.wysokoscGraniastoslupa = wysokoscGraniastoslupa;
    }
    public void showObjGraniastoslupa(){
        System.out.println("Objetosc graniastoslupa: " + super.poleTrojkata()*wysokoscGraniastoslupa);
    }
    public void showPoleGraniastoslupa(){
        System.out.println("Pole graniastoslupa: "+ ((2*super.poleTrojkata())+(3*super.getBokA()*wysokoscGraniastoslupa)));

    }

}
