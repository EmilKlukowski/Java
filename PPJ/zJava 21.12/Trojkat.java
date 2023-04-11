package PPJ21;

public class Trojkat {
    private double bokA;
    private double wysokoscTrojkata;
    private double poleTrojkata;

    public Trojkat(double bokA, double wysokoscTrojkata) {
        this.bokA = bokA;
        this.wysokoscTrojkata = wysokoscTrojkata;
        poleTrojkata=1.0/2*this.bokA*this.wysokoscTrojkata;
    }

    public double getBokA() {
        return bokA;
    }

    public double poleTrojkata(){
        return poleTrojkata;
    }
    public void showpoleTrojkata(){
        System.out.println("Pole trojkata: " + poleTrojkata);
    }
}
