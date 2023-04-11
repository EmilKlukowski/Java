package GUI2;

public abstract class Zwierze {
    public abstract String odglos();

    public void koncert() {
        System.out.println(odglos());
    }

    public int ilePowtorzen() {
        int czasKoncertu = 2;
        return czasKoncertu;
    }
}
