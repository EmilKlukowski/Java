package PPJ21;

public class Ostroslup extends Trojkat{
    private double wysokoscOstroslupa;

    public Ostroslup(double bokA, double wysokoscTrojkata, double wysokoscOstroslupa) {
        super(bokA, wysokoscTrojkata);
        this.wysokoscOstroslupa = wysokoscOstroslupa;
    }

    public void showObjOstroslupa(){
        System.out.println("Obj ostroslupa: " + super.poleTrojkata()*
                this.wysokoscOstroslupa*1.0/3);
    }
    public void showPoleOstroslupa(){
        System.out.println("Pole ostroslupa: " + 4*super.poleTrojkata());
    }
}
