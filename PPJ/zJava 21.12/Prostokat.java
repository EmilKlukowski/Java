package PPJ21;

public class Prostokat {
    private int dlugosc;
    private int szerokosc;
    private int polePodstawy;
    public Prostokat(int dlugosc, int szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        polePodstawy=this.dlugosc*this.szerokosc;
    }

    public int poleProstokata(){
        return polePodstawy;
    }
    public void showPoleProstokata(){
        System.out.println("Pole prostokata: " + polePodstawy);
    }
}
